package com.ict.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.Paging;
import com.ict.service.CVO;
import com.ict.service.DAO;
import com.ict.service.EVO;
import com.ict.service.IVO;
import com.ict.service.MVO;
import com.ict.service.ODVO;
import com.ict.service.OVO;
import com.ict.service.RVO;


@Controller
public class SfController {
	@Autowired
	private DAO dao;
	@Autowired
	private Paging paging;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	
	// index 
	@RequestMapping("index.do")
	public ModelAndView indexCommand() {
			/*@RequestParam("cntPage")String cntPage) {*/
		ModelAndView mv = new ModelAndView("index");
		//mv.addObject("cntPage", cntPage);
		return mv;
	}
	
		
	//notice
	@RequestMapping("main_notice.do")
	public ModelAndView mainNoticeCommand() {
		//System.out.println("main_notice.do");
		ModelAndView mv = new ModelAndView("main_notice");
		return mv;
	}
	
	//q&a
	@RequestMapping("item_qa.do")
	public ModelAndView itemQACommand() {
		//System.out.println("item_qa.do");
		ModelAndView mv = new ModelAndView("item_qa");
		return mv;
	}
	
	
	
	////////////////////////////       Item 관련  /////////////////////////////////////////////////////////////////
	//main
	@RequestMapping("item.do")
	public ModelAndView itemSubCommand(@RequestParam("item_category") String item_category,
			HttpSession session) {
		
		ModelAndView mv = new ModelAndView("item");
		List<IVO> itemlist = null;
		try {
			
			itemlist = dao.getItemList(item_category);
		
			//이벤트 정보 가져오기 성공하면
			if(itemlist!= null) {
				session.setAttribute("itemlist", itemlist);
			} else {
				System.out.println("item이 없네");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	// 하나의 제품의 상세정보 가져오기 - item sub
	@RequestMapping("item_sub_detail.do")
	public ModelAndView oneItemDetailCommand(@RequestParam("idx") String idx,
			HttpSession session) {
		ModelAndView mv = new ModelAndView("item_sub_detail");
		
		try {
			IVO ivo = dao.getItemSubDetail(idx);
			session.setAttribute("ivo", ivo);
			//mv.addObject("ivo", ivo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
		
	}
	
	// insert item
	@RequestMapping(value = "insert_item.do", method = RequestMethod.GET)
	public ModelAndView insertItemCommand_Get(IVO ivo) {
		return new ModelAndView("item_insert");
	}
	
	
	@RequestMapping(value = "insert_item.do", method = RequestMethod.POST)
	public ModelAndView insertItemCommand(IVO ivo, 
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/images/items");
			MultipartFile file = ivo.getFile();
		
			if (file.isEmpty()) {
				ivo.setFile_name("");
			} else {
				ivo.setFile_name(ivo.getFile().getOriginalFilename());
			}
			
			int result = dao.insertItem(ivo);
			
			if (result > 0) {
				file.transferTo(new File(path + "/" + ivo.getFile_name()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//성공하면 
		mv.setViewName("redirect:item.do?item_category=" + ivo.getItem_category());
		return mv;
	}
	
	
	// update item
	@RequestMapping(value = "update_item.do", method = RequestMethod.GET)
	public ModelAndView updateItemCommand_Get(IVO ivo) {
		return new ModelAndView("item_update");
	}
	
	
	@RequestMapping(value = "update_item.do", method = RequestMethod.POST)
	public ModelAndView updateItemCommand(IVO ivo, 
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/images/items");
			MultipartFile file = ivo.getFile();
		
			if (file.isEmpty()) {
				ivo.setFile_name("");
			} else {
				ivo.setFile_name(ivo.getFile().getOriginalFilename());
			}
			
			int result = dao.updateItem(ivo);
			
			
			if (result > 0) {
				file.transferTo(new File(path + "/" + ivo.getFile_name()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//성공하면 
		mv.setViewName("redirect:item.do?item_category=" + ivo.getItem_category());
		return mv;
	}
	
	// 회원가입관련(Join)
	@RequestMapping("join.do")
	public ModelAndView joinCommand() {
		return new ModelAndView("join");
	}
	
	/*
	// 주소검색
	@RequestMapping("addr_search.do")
	public ModelAndView addrTestCommand() {
		ModelAndView mv = new ModelAndView("addr_search");
		return mv;
	}
	*/
	
	
	////////////////// Join(회원 가입)////////////////////////////////////
	@RequestMapping("join_ok.do")
	public ModelAndView joinOKCommand(MVO mvo,
			HttpSession session) {
		ModelAndView mv = new ModelAndView("home");
		int result = 0;
		try {
			result = dao.insertMember(mvo);
			if(result > 0) {
				session.setAttribute("mvo", mvo);
				session.setAttribute("join", "ok");
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		return mv;
	}
	
	// 회원 정보 검색, 수정
	@RequestMapping("cust_info.do")
	public ModelAndView custInfoCommand() {
		return new ModelAndView("cust_info");
	}
	
	
//////////////////Login(로그인)////////////////////////////////////
	@RequestMapping("login.do")
	public ModelAndView loginCommand(HttpSession session) {
		//로그인 되어 있으면 로그아웃 시키고 다른 아이디 로그인하게 만들기
		session.invalidate();
		return new ModelAndView("login");
	}
	
	@RequestMapping("login_ok.do")
	public ModelAndView login_okCommand(MVO m_vo,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		try {
			// 로그인 처리
			MVO mvo = dao.getLogin(m_vo);
			
			// 로그인 성공
			if(mvo != null) {
				session.setAttribute("mvo", mvo);
				session.setAttribute("login", "ok");
				// 관리자
				if(mvo.getId().equals("admin") 
					&& mvo.getPwd().equals("1111")) {
					session.setAttribute("admin", "ok");
				}
				mv.setViewName("index");
			}else {
				mv.setViewName("redirect:login.do");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return mv;
	}
	
	
	
	// 로그 아웃하기
	@RequestMapping("logout.do")
	public ModelAndView logoutCommand(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:index.do");
	}
	
	
	/////////      Event     //////////////////////////////////
	// Event - get all of information
	@RequestMapping("event.do")
	public ModelAndView eventCommand(HttpSession session) {
		System.out.println("event.do");
		ModelAndView mv = new ModelAndView("event");
		
		List<EVO> evlist = null;
		
		try {
			evlist = dao.getEventList();
						
			//이벤트 정보 가져오기 성공하면
			if(evlist!= null) {
				session.setAttribute("evlist", evlist);
				
			} else {
				System.out.println("이벤트가 없음");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return mv;
	}
	 	
	// 이벤트 상세 정보 가져오기
	@RequestMapping("event_sub.do")
	public ModelAndView eventSubCommand(
			@RequestParam("idx") String idx, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		try {
			EVO evo = dao.getSubEvent(idx);
		
			//이벤트 정보 가져오기 성공하면
			if(evo != null) {
				session.setAttribute("evo", evo);
				mv.setViewName("event_sub");
			} else {
				mv.setViewName("event");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return mv;
	}
	

	// insert event
	@RequestMapping(value = "insert_event.do", method = RequestMethod.GET)
	public ModelAndView insertEventCommand_Get(EVO evo) {
		return new ModelAndView("event_insert");
	}

	@RequestMapping(value = "insert_event.do", method = RequestMethod.POST)
	public ModelAndView insertEventCommand(EVO evo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		try {

			String path = request.getSession().getServletContext().getRealPath("/resources/images/events");
			MultipartFile lg_file = evo.getLg_file();
			MultipartFile sm_file = evo.getSm_file();

			if (lg_file.isEmpty()) {
				evo.setLg_img("");
			} else {
				evo.setLg_img(evo.getLg_file().getOriginalFilename());
			}

			if (sm_file.isEmpty()) {
				evo.setSm_img("");
			} else {
				evo.setSm_img(evo.getSm_file().getOriginalFilename());
			}

			int result = dao.insertEvent(evo);

			if (result > 0) {
				sm_file.transferTo(new File(path + "/" + evo.getSm_img()));
				lg_file.transferTo(new File(path + "/" + evo.getLg_img()));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 성공하면
		mv.setViewName("redirect:event.do");
		return mv;
	}
	
	
	//update event
	@RequestMapping( "update_event.do")
	public ModelAndView updateEventCommand_Get() {	
		return new ModelAndView("event_update");
	}

	@RequestMapping( "update_event_ok.do")
	public ModelAndView updateEventOKCommand_Get(EVO evo) {
		return new ModelAndView("update_event");
	}

	@RequestMapping(value = "update_event_ok.do", method = RequestMethod.POST)
	public ModelAndView updateEventOKCommand(EVO evo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		try {
			
			String path = request.getSession().getServletContext().getRealPath("/resources/images/events");
			MultipartFile lg_file = evo.getLg_file();
			MultipartFile sm_file = evo.getSm_file();
			
			
			if (lg_file.isEmpty()) {
				evo.setLg_img("");
			} else {
				evo.setLg_img(evo.getLg_file().getOriginalFilename());
			}

			if (sm_file.isEmpty()) {
				evo.setSm_img("");
			} else {
				evo.setSm_img(evo.getSm_file().getOriginalFilename());
			}
			
			int result = dao.updateEvent(evo);
			

			if (result > 0) {
				sm_file.transferTo(new File(path + "/" + evo.getSm_img()));
				lg_file.transferTo(new File(path + "/" + evo.getLg_img()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 성공하면
		mv.setViewName("redirect:event.do");
	
		return mv;
	}
	
	
		
	
	
	@RequestMapping("admin_review.do")
	public ModelAndView adminReviewCommand() {
		ModelAndView mv = new ModelAndView("admin_review");
		return mv;
	}
	
	
	@RequestMapping("admin_item_qa.do")
	public ModelAndView adminItemQACommand() {
		ModelAndView mv = new ModelAndView("admin_item_qa");
		return mv;
	}
	
	@RequestMapping("insert_item.do")
	public ModelAndView insertItemCommand() {
		ModelAndView mv = new ModelAndView("item_insert");
		return mv;
	}
	
	
	////////////////////////////////////////////////////////
	//////////   Cart(카트 관련) ///////////////////////////
	@RequestMapping("cart_list.do")
	public ModelAndView cartListCommand(
			@RequestParam("cust_id") String cust_id) {
		ModelAndView mv = new ModelAndView("cart_list");
		try {
			List<CVO> cart_list = dao.getCartList(cust_id);
			mv.addObject("cart_list", cart_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("edit_cart_quantity.do")
	public ModelAndView editeCountCommand(CVO cvo) {
		try {
			dao.getCartEdit(cvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("redirect:cart_list.do?cust_id="+cvo.getCust_id());
	}
	
	@RequestMapping("add_cart.do")
	public ModelAndView addCartCommand(
			@RequestParam("cust_id") String cust_id,
			@RequestParam("idx") String idx) {
		ModelAndView mv = new ModelAndView("redirect:cart_list.do?cust_id="+ cust_id);
				
		try {
			// idx를 이용해서 제품 정보 가져오기 
			IVO ivo = dao.getItemSubDetail(idx);
						
			// id와 제품번호를 가지고 카드 정보 가져오기 
			CVO cvo = dao.getCartItem(cust_id, idx);
			
			// 해당 제품이 카드정보 존재 유무를 확인
			// 존재하면 갯수만 증가, 존재하지 않으면 해당 제품을 카트 정보 추가
			if(cvo == null) {
			// 카트에 제품이 없으므로 카트에 추가 
				 CVO c_vo = new CVO();
				 c_vo.setItem_id(idx);
				 c_vo.setItem_price(String.valueOf(ivo.getItem_price()));
				 c_vo.setItem_name(ivo.getItem_name());
				 c_vo.setCust_id(cust_id);
				 dao.insertCart(c_vo);
			}else {
			// 카트에 제품이 있으므로 제품의 갯수를 1증가 시킨다.
				dao.updateCart(cvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv ;
		
	}
	
	@RequestMapping("delete_cart.do")
	public ModelAndView deleteCartCommand(CVO cvo) {
		ModelAndView mv = new ModelAndView("redirect:cart_list.do?cust_id="+ cvo.getCust_id());
		int result = 0;
		
		try {

			result = dao.deleteCart(cvo);
		} catch (Exception e) {
			System.out.println("3");
			e.printStackTrace();
		}
		
		System.out.println("result : " + result);
		return mv;
	}
	
	
	@RequestMapping("cust_order.do")
	public ModelAndView custOrderCommand(
			@RequestParam("cust_id") String cust_id,
			@RequestParam("total_price") String total_price,
			HttpServletRequest request) {
		
		int result = 0;
		
		
		
		// 검색 후 데이터 가져온 후 장바구니 내용 삭제.
		try {
			// 장바구니 내용을 order 테이블로 이동
			result =  dao.insertOrder(cust_id, total_price);
			
			if(result > 0) {
				result = 0;
				
				String order_id = dao.getOrderId(cust_id, total_price);
				
				
				System.out.println("o_id :" + order_id);
				List<CVO> cart_list = dao.getCartList(cust_id);
				
				
				for (CVO c : cart_list) {
					ODVO odvo = new ODVO();
					odvo.setOrder_id(order_id);
					odvo.setItem_id(c.getItem_id());
					odvo.setItem_name(c.getItem_name());
					odvo.setItem_price(c.getItem_price());
					odvo.setItem_quantity(c.getItem_amount());
					odvo.setCh_review("no");
					
					//System.out.println("item_id :" + odvo.getItem_id());
					//System.out.println("item_name :" + odvo.getItem_name());
					//System.out.println("item_price :" + odvo.getItem_price());
					//System.out.println("item_quantity :" + odvo.getItem_quantity());
					//System.out.println("order_id :" + odvo.getOrder_id());
					
					// 주문  세부 정보 넣기
					dao.insertOrderDetail(odvo);
					
					// 장바구니 레코드 삭제
					dao.deleteCart(c);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("redirect:order_list.do?cust_id="+cust_id);
		return mv;
	}
	
	/////////////////////////////////////////////////////////
	////////   order (주문)  /////////
	@RequestMapping("order_list.do")
	public ModelAndView orderListCommand(
			@RequestParam("cust_id") String cust_id) {
		
		ModelAndView mv = new ModelAndView("order_list");
		List<OVO> order_list;
		try {
			if(cust_id.equalsIgnoreCase("admin")) {
				order_list = dao.getAdminOrderList();  
			}else {
				// in case of login for user
				order_list = dao.getCustOrderList(cust_id);  
			}
			mv.addObject("order_list", order_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return mv;
	}
	
	@RequestMapping("order_status_update.do")
	public ModelAndView adminOrderStatusUpdate(
			@RequestParam("order_id")String order_id,
			@RequestParam("order_status")String order_status
			) {
		ModelAndView mv = new ModelAndView("redirect:order_list.do?cust_id=admin");
		
		try {
			dao.updateOrderStatus(order_id, order_status);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return mv;
	}
	
	// 하나의 주문 상세 정보 보기.
	@RequestMapping("order_detail.do")
	public ModelAndView custOrderDetailCommand(
			@RequestParam("order_id")String order_id)  {
		ModelAndView mv = new ModelAndView("order_detail");
		try {
			// 하나의 주문에 대한 정보를 가져오기
			OVO ovo = dao.getOneOrder(order_id);
			mv.addObject("one_order", ovo);
			
			
			List<ODVO> order_detail = dao.getOrderDetail(order_id);
			mv.addObject("order_detail", order_detail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	////////////////////////////////////////////////////////////////////////
	// review 리뷰
	@RequestMapping("review.do")
	public ModelAndView reviewCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("review");
		
		try {
			// 1. 전체 게시물의 수
			int count = dao.getTotalCount();
			paging.setTotalRecord(count);
			
			// 2. 전체 게시물의 수를 가지고 전체 페이지의 수를 구하자.
			// 전체 게시물의 수가 getNumPerPage(5) 보다 작거나 같으면 전체 페이지의 수는 1페이지
			if(paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			}else {
				paging.setTotalPage(paging.getTotalRecord()/paging.getNumPerPage());
				// 나눠서 나머지가 0이 아니면 현재 페이지에서 한페이지 증가 시키자 
				if(paging.getTotalRecord()%paging.getNumPerPage() != 0) {
					paging.setTotalPage(paging.getTotalPage()+1);
				}
			}
			
			String cPage = request.getParameter("cPage");
			// index에서 넘어오면 cPage의 무조건 null이다.
			// 나머지는 list에 넘어올때 무조건 cPage값을 넣어줘야 한다.
			// cPage가 현재 페이지(nowPage)로 변경
			if(cPage == null) {
				paging.setNowPage(1);
			}else {
				paging.setNowPage(Integer.parseInt(cPage));
			}
			
			// 시작번호, 끝번호 
			paging.setBegin((paging.getNowPage()-1)*paging.getNumPerPage()+1);
			paging.setEnd((paging.getBegin()-1) + paging.getNumPerPage());
			
			
		    // 시작 블록과 끝블록
			paging.setBeginBlock((int)((paging.getNowPage()-1) / paging.getPagePerBlock()) * paging.getPagePerBlock()+1);
			paging.setEndBlock(paging.getBeginBlock()+paging.getPagePerBlock()-1);
			
			// 주의사항 : endBlock이 totalPage보다 클수 있다.
			// 이때는  endBlock를 totalPage에 맞춰 주세요
			if(paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}
			
			List<RVO> review_list = dao.getList(paging.getBegin(), paging.getEnd());
			
			mv.addObject("review_list", review_list);
			mv.addObject("paging", paging);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
	@RequestMapping("review_write.do")
	public ModelAndView reviewWriteCommand(HttpServletRequest request,
			@RequestParam("order_detail_id") String order_detail_id,
			@RequestParam("cust_id") String cust_id,
			@RequestParam("item_id") String item_id,
			@RequestParam("item_name") String item_name) {
		ModelAndView mv = new ModelAndView("review_write");
		mv.addObject("order_detail_id", order_detail_id);
		mv.addObject("cust_id", cust_id);
		mv.addObject("item_id", item_id);
		mv.addObject("item_name", item_name);
		return mv;
	}
	
	@RequestMapping(value="review_write_ok.do", method = RequestMethod.GET)
	public ModelAndView write_OKCommand() {
		return new ModelAndView("review_write");
	}
	@RequestMapping(value="review_write_ok.do", method = RequestMethod.POST)
	public ModelAndView write_OKCommand_POST(
			@RequestParam("order_detail_id") String order_detail_id,
			RVO rvo, HttpSession session ) {
		ModelAndView mv = new ModelAndView("redirect:review.do");
		try {
			String path = session.getServletContext().getRealPath("/resources/images/reviews");
			MultipartFile file = rvo.getFile();
			if(file.isEmpty()) {
				rvo.setFile_name("");
			}else {
				rvo.setFile_name(file.getOriginalFilename());
			}
			System.out.println("item_name:" + rvo.getItem_name());
			int result = dao.reviewInsert(rvo);
			if(result >0) {
				file.transferTo(new File(path + "/" + rvo.getFile_name()));
			}
			
			// update - sf_order_detail 's ch_review field
			dao.updateOrderDetailChReview(order_detail_id);
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	@RequestMapping("review_detail.do")
	public ModelAndView reviewDetailCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("review_detail");
		try {
			String idx = request.getParameter("idx");
			String cPage = request.getParameter("cPage");
			
			// hit update
			  dao.getHitUpdate(idx);
			  
			// 상세보기
			  RVO rvo = dao.getOneReviewList(idx);
			  
			// 수정과 삭제를 위해서 세션에 저장
			 request.getSession().setAttribute("rvo", rvo); 
			 
			 mv.addObject("cPage", cPage);
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	@RequestMapping("review_ans_write.do")
	public ModelAndView ans_WriteCommnad(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("review_ans_write");
	}
	
	@RequestMapping(value="review_ans_write_ok.do", method = RequestMethod.GET)
	public ModelAndView ans_WriteCommand_GET(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("review_ans_write");
	}
	
	@RequestMapping(value="review_ans_write_ok.do", method = RequestMethod.POST)
	public ModelAndView ans_WriteCommand_POST(
			@ModelAttribute("cPage")String cPage,
			RVO rvo, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:review.do");
		try {
			int lev  = Integer.parseInt(rvo.getLev());
			int step = Integer.parseInt(rvo.getStep());
			int groups = Integer.parseInt(rvo.getGroups());
			
			step ++ ;
			lev ++ ;
			
			// DB에 groups, lev를 업데이트 한다.
			// groups는 같은 원글 찾아서 레벨이 같거나 크면, 레벨 증가
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("groups", groups);
			map.put("lev", lev);
			
			dao.reviewLevUp(map);
			
			rvo.setStep(String.valueOf(step));
			rvo.setLev(String.valueOf(lev));
			
			String path = session.getServletContext()
					.getRealPath("/resources/images/reviews");
			MultipartFile file = rvo.getFile();
			
			if(file.isEmpty()) {
				rvo.setFile_name("");
			}else {
				rvo.setFile_name(file.getOriginalFilename());
			}
			int result = dao.reviewAnsInsert(rvo);
			if(result>0) {
				file.transferTo(new File(path+"/"+rvo.getFile_name()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	
	
	@RequestMapping("review_update.do")
	public ModelAndView updateCommand(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("review_update");
	}
	
	@RequestMapping(value="review_update_ok.do", method = RequestMethod.GET)
	public ModelAndView update_OkCommand_GET(
			@ModelAttribute("cPage")String cPage){
		return new ModelAndView("update");
	}
	
	@RequestMapping(value="review_update_ok.do", method = RequestMethod.POST)
	public ModelAndView update_OkCommand_POST(
			@ModelAttribute("cPage")String cPage,
			RVO rvo, HttpSession session){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:review_detail.do?idx="+rvo.getIdx());
		try {
			String path = session.getServletContext().getRealPath("/resources/images/review");
			MultipartFile file = rvo.getFile();
			if(file.isEmpty()) {
				rvo.setFile_name("");
			}else {
				rvo.setFile_name(file.getOriginalFilename());
			}
			
			System.out.println("idx:" +rvo.getIdx() );
			
			int result = dao.reviewUpdate(rvo);
			if(result>0) {
				file.transferTo(new File(path+"/"+rvo.getFile_name()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	
	
	
	@RequestMapping("review_delete")
	public ModelAndView reviewDeleteCommand(
			@ModelAttribute("cPage")String cPage,
			@RequestParam("idx")String idx) {
		try {
			dao.reviewDelete(idx);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("redirect:review.do");
	}
	
	
	
	
	
}
