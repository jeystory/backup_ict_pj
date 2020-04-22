package com.ict.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class DAO {
	private SqlSessionTemplate sqlSessionTemplate;
	private DataSourceTransactionManager transactionManager ;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	
	
	//get item info
	public List<IVO> getItemList(String item_category) throws Exception{
		return sqlSessionTemplate.selectList("get_item_list", item_category);
	}
	
	public IVO getItemSubDetail(String idx) throws Exception{
		IVO ivo = new IVO();
		
		ivo = sqlSessionTemplate.selectOne("item_sub_detail", idx);
		return ivo;
	}
	
	public int insertItem(IVO ivo)  throws Exception {
		int result = 0;
		
		result = sqlSessionTemplate.insert("insert_item", ivo);
				
		return result;
	}
	
	public int updateItem(IVO ivo)  throws Exception {
		int result  = 0;
		
		System.out.println("idx" + ivo.getIdx());
		System.out.println("cat" + ivo.getItem_category());
		System.out.println("name" + ivo.getItem_name());
		System.out.println("item_spec" + ivo.getItem_spec());
		System.out.println("item_price" + ivo.getItem_price());
		System.out.println("item_con" + ivo.getItem_content());
		System.out.println("item_aller" + ivo.getItem_aller());
		System.out.println("item_cal" + ivo.getItem_cal());
		System.out.println("file" + ivo.getFile_name());
		
		result =  sqlSessionTemplate.update("update_item", ivo);
		return result;
	}
	
	
	
	public MVO getLogin(MVO mvo) throws Exception{
		System.out.println(mvo.getId());
		return sqlSessionTemplate.selectOne("login", mvo);
	}
	
	//Event Info
	public List<EVO> getEventList() throws Exception {	
		return sqlSessionTemplate.selectList("get_event_list");
	}
	
		
	public EVO getSubEvent(String idx) throws Exception{
		System.out.println("dao idx " + idx);
		return sqlSessionTemplate.selectOne("get_sub_event", idx);
	}
	
	public int insertEvent(EVO evo) throws Exception{
		int result = 0;
		
		result = sqlSessionTemplate.insert("insert_event", evo);
		
		return result;
	}
	
	public List<CVO> getCartList(String cust_id) throws Exception{
		List<CVO> list = sqlSessionTemplate.selectList("get_cart_list", cust_id);
		return list;
	}
	
	public void getCartEdit(CVO cvo) throws Exception{
		sqlSessionTemplate.update("cart_edit", cvo);
	}
	
	public CVO getCartItem(String cust_id, String item_id)   throws Exception{
		CVO cvo = null;
		Map< String, String> map = new HashMap<String, String>();
		
		map.put("cust_id",cust_id);
		map.put("item_id",item_id);
		cvo  = sqlSessionTemplate.selectOne("get_cart_item", map);
		return cvo;
		
		
	}
	
	public void insertCart(CVO cvo)throws Exception{
		
		sqlSessionTemplate.insert("cart_insert", cvo);
	}

	public void updateCart(CVO cvo) throws Exception{
		sqlSessionTemplate.update("cart_update", cvo);
	}
	
	public int deleteCart(CVO cvo) throws Exception{
		int result = sqlSessionTemplate.delete("cart_delete", cvo);
		return result;
	}
	
	
	//join member
	public int insertMember(MVO mvo) throws Exception{
		return sqlSessionTemplate.insert("member_insert", mvo);
	}
	
	// order
	public int insertOrder(String cust_id, String total_price) throws Exception{
		Map<String, String>  map = new HashMap<String, String>();
		map.put("cust_id", cust_id);
		map.put("total_price", total_price);
		int result = sqlSessionTemplate.insert("order_insert",map );		
		
		return result;
		
	}
	
	//order detail
	public int insertOrderDetail(ODVO odvo) throws Exception{
		int result = 0;
		
		result = sqlSessionTemplate.insert("order_detail_insert", odvo);
		
		return result;
	}
	
	//get order id
	public String getOrderId(String cust_id, String total_price) throws Exception{
		
		Map<String, String>  map = new HashMap<String, String>();
		map.put("cust_id", cust_id);
		map.put("total_price", total_price);
		
		return  sqlSessionTemplate.selectOne("order_id_get", map);
				
	}
	
	//get order list
	public List<OVO> getCustOrderList(String cust_id) throws Exception{
		return sqlSessionTemplate.selectList("cust_order_list", cust_id); 
	}
	
	// get one order info
	public OVO getOneOrder(String order_id) throws Exception{
		return sqlSessionTemplate.selectOne("one_order_get", order_id);
	}
	
	
	// get a order detail 
	public List<ODVO> getOrderDetail(String order_id) throws Exception{
				
		return sqlSessionTemplate.selectList("order_detail", order_id);
		
	}
	
	// all of order list for admin
	public List<OVO> getAdminOrderList() throws Exception{
		return sqlSessionTemplate.selectList("admin_order_list");
	}
	
	
	//update one admin order list
	public int  updateOrderStatus(String order_id, String order_status) throws Exception{
		int result = 0;
		Map<String, String>  map = new HashMap<String, String>();
		map.put("order_id", order_id);
		map.put("order_status", order_status);
		
		System.out.println("dao order id " + order_id);
		
		result = sqlSessionTemplate.update("update_order_status", map);
		
		System.out.println("result  " + result);
		return result;
	}
	
	//update - sf_order_detail tb's ch_review field
	public int updateOrderDetailChReview(String order_detail_id) {
		int result = 0;
		
		Map<String, String>  map = new HashMap<String, String>();
		map.put("order_detail_id", order_detail_id);
		map.put("ch_review", "yes");
		result = sqlSessionTemplate.update("update_order_detail_review", map);
		
		return result;
	}
	
	public int updateEvent(EVO evo) {
		int result = 0;
		
		result = sqlSessionTemplate.update("update_event", evo);
		
		return result;
	}
	
	// Review  관련
	// 전체 게시물의 수
	public int getTotalCount() throws Exception {
		return sqlSessionTemplate.selectOne("totalCount");
	}
	
	// 리스트
	public List<RVO> getList(int begin, int end)throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("review_list", map);
	}
	
	// 원글 삽입
	public int reviewInsert(RVO rvo) throws Exception {
		return sqlSessionTemplate.insert("review_insert", rvo);
	}
	
	// hit 업데이트
	public void getHitUpdate(String idx) throws Exception{
		sqlSessionTemplate.update("review_hit", idx);
	}
	
	// 상세보기
	public RVO getOneReviewList(String idx) throws Exception{
		return sqlSessionTemplate.selectOne("one_review_list", idx);
	}
	
	// levUp
	public int reviewLevUp(Map<String, Integer> map) throws Exception {
		return sqlSessionTemplate.update("review_levup", map);
	}
	
	// 댓글 삽입
	public int reviewAnsInsert(RVO rvo) throws Exception {
		return sqlSessionTemplate.insert("review_ans_insert", rvo);
	}
	
	// 삭제
	public void reviewDelete(String idx) throws Exception{
		sqlSessionTemplate.delete("review_delete", idx);
	}
	
	// 업데이트
	public int reviewUpdate(RVO rvo) throws Exception{
		return sqlSessionTemplate.update("review_update", rvo);
	}
		
}
