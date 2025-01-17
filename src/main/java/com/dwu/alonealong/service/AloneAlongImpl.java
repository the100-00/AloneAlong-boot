package com.dwu.alonealong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwu.alonealong.dao.UserDAO;
import com.dwu.alonealong.dao.CartItemDAO;
import com.dwu.alonealong.dao.FoodDAO;
import com.dwu.alonealong.dao.FoodLineItemDAO;
import com.dwu.alonealong.dao.FoodOrderDAO;
import com.dwu.alonealong.dao.FoodReviewDAO;
import com.dwu.alonealong.dao.OrderInfoDAO;
import com.dwu.alonealong.dao.PaymentDAO;
import com.dwu.alonealong.dao.ProductDAO;
import com.dwu.alonealong.dao.ProductOrderDAO;
import com.dwu.alonealong.dao.ProductReviewDAO;
import com.dwu.alonealong.dao.RestaurantDAO;
import com.dwu.alonealong.dao.TogetherDAO;
import com.dwu.alonealong.dao.TogetherFoodDAO;
import com.dwu.alonealong.dao.TogetherMemberDAO;
import com.dwu.alonealong.dao.TogetherOrderDAO;
import com.dwu.alonealong.domain.CartItem;
import com.dwu.alonealong.domain.Food;
import com.dwu.alonealong.domain.FoodCart;
import com.dwu.alonealong.domain.FoodCartItem;
import com.dwu.alonealong.domain.FoodLineItem;
import com.dwu.alonealong.domain.FoodOrder;
import com.dwu.alonealong.domain.FoodReview;
import com.dwu.alonealong.domain.Order;
import com.dwu.alonealong.domain.Payment;
import com.dwu.alonealong.domain.Product;
import com.dwu.alonealong.domain.ProductOrder;
import com.dwu.alonealong.domain.ProductReview;
import com.dwu.alonealong.domain.Restaurant;
import com.dwu.alonealong.domain.Together;
import com.dwu.alonealong.domain.TogetherFood;
import com.dwu.alonealong.domain.TogetherMember;
import com.dwu.alonealong.domain.TogetherOrder;
import com.dwu.alonealong.domain.User;

@Service
@Transactional
public class AloneAlongImpl implements AloneAlongFacade{

	//restaurant
	@Autowired
	private RestaurantDAO restaurantDao;	
	@Autowired
	private FoodDAO foodDao;
	@Autowired
	private FoodLineItemDAO foodLineItemDao;
	@Autowired
	private FoodOrderDAO foodOrderDao;
	@Autowired
	private OrderInfoDAO orderInfoDao;
	@Autowired
	private FoodReviewDAO foodReviewDao;
	
	
    @Autowired
	private UserDAO userDao;
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private ProductReviewDAO productReviewDao;
	@Autowired
	private ProductOrderDAO productOrderDao;
	
	@Autowired
	private PaymentDAO paymentDao;
	@Autowired
	private CartItemDAO cartItemDao;
	
//	private ProductDAO productDao;
//	private ProductReviewDAO productReviewDao;
//	private ProductOrderDAO productOrderDao;
//	private PaymentDAO paymentDao;
	
	@Autowired
	private TogetherDAO togetherDao;
	@Autowired
	private TogetherFoodDAO togetherFoodDao;
	@Autowired
	private TogetherMemberDAO togetherMemberDao;
	@Autowired
	private TogetherOrderDAO togetherOrderDao;

	//User
	public User getUserByUserId(String Id) throws DataAccessException{
		return userDao.getUserByUserId(Id);
	}
	
	public User getUserByUserIdAndPassword(String Id, String password) throws DataAccessException{
		return userDao.getUserByUserIdAndPassword(Id, password);
	}
	public void createUser(User user) {
		userDao.createUser(user);
		return;
	}
	public void updateUser(User user) {
		userDao.updateUser(user);
		return;
	}
	public void removeUser(String Id) {
		userDao.removeUser(Id);
		return;
	}
	public List<String> getUserIdList(){
		return userDao.getUserIdList();
	}
	
	//Contact
	public void insertContact(String contents) {
		userDao.insertContact(contents);
	}
	
	//Product
	public List<Product> getProductList(int pcId, String sortType){
		return productDao.getProductList(pcId, sortType);
	}
	public List<Product> searchProductList(String keywords){
		return productDao.searchProductList(keywords);
	}
	public Product getProduct(String productId){
		return productDao.getProduct(productId);
	}
	public boolean checkStock(String productId, int quantity) {
		return productDao.checkStock(productId, quantity);
	}
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}
	
	//Product Review
	public ProductReview getProductReview(String reviewId, String userId){
		return productReviewDao.getProductReview(reviewId, userId);
	}
	public List<ProductReview> getProductReviewList(String productId, String sortType, String userId){
		return productReviewDao.getProductReviewList(productId, sortType, userId);
	}
	public List<ProductReview> getProductReviewListByUserId(String userId){
		return productReviewDao.getProductReviewListByUserId(userId);
	}
	public void insertProductReview(ProductReview productReview) {
		productReviewDao.insertProductReview(productReview);
		return;
	}
	public void updateProductReview(ProductReview productReview) {
		productReviewDao.updateProductReview(productReview);
		return;
	}
	public void deleteProductReview(String reviewId) {
		productReviewDao.deleteProductReview(reviewId);
		return;
	}
	public int numOfReviews(String productId) {
		return productReviewDao.numOfReviews(productId);
	}
	public double averageOfReviews(String productId){
		return productReviewDao.averageOfReviews(productId);
	}
	public int mostRatingOfReviews(String productId){
		return productReviewDao.mostRatingOfReviews(productId);
	}
	public void insertProductReviewRecommend(String reviewId, String userId){
		productReviewDao.insertProductReviewRecommend(reviewId, userId);
		return;
	}
	public void deleteProductReviewRecommend(String reviewId, String userId){
		productReviewDao.deleteProductReviewRecommend(reviewId, userId);
		return;
	}
	
	//PRODUCT Order
	public List<ProductOrder> getOrdersByUserId(String userId){
		return productOrderDao.getOrdersByUserId(userId);
	}
//	public List<ProductOrder> getProductOrdersByProductId(String productId){
//		return productOrderDao.getOrdersByProductId(productId);
//	}
	public ProductOrder getProductOrder(String orderId){
		return productOrderDao.getProductOrder(orderId);
	}
	public void insertProductOrder(ProductOrder order){
		productOrderDao.insertProductOrder(order);
	}
	public boolean checkUsersOrder(String userId, String productId){
		return productOrderDao.checkUsersOrder(userId, productId);
	}
	
	//cart
	public List<CartItem> getAllCartItem(String userId) throws DataAccessException{
		return cartItemDao.getAllCartItem(userId);
	}
	public CartItem getCartItem(String cartItemId) throws DataAccessException{
		return cartItemDao.getCartItem(cartItemId);
	}
	public void insertCartItem(String productId, int quantity, String userId)  throws DataAccessException{
		cartItemDao.insertCartItem(productId, quantity, userId);
		return;
	}
	public void deleteCartItem(String cartItemId) throws DataAccessException{
		cartItemDao.deleteCartItem(cartItemId);
		return;
	}
	public void deleteAllCartItem(String userId) throws DataAccessException{
		cartItemDao.deleteAllCartItem(userId);
		return;
	}
	public void updateCartItem(CartItem cartItem) throws DataAccessException{
		cartItemDao.updateCartItem(cartItem);
		return;
	}
	
	//Payment
	public Payment getCard(String Id) throws DataAccessException{
		return paymentDao.getCard(Id);
	}
	public void createCard(Payment payment) {
		paymentDao.createCard(payment);
	}
	public void updateCard(Payment payment) {
		paymentDao.updateCard(payment);
	}
	
	//Restaurant
	@Override
	public void insertRestaurant(Restaurant res) {
		restaurantDao.insertRestaurant(res);
	}
	@Override
	public void updateRestaurant(Restaurant res) {
		restaurantDao.updateRestaurant(res);
	}
	@Override
	public void deleteRestaurant(String ownerId) {
		restaurantDao.deleteRestaurant(ownerId);
	}
	@Override
	public List<Restaurant> getRestaurantList() {
		return restaurantDao.getRestaurantList();
	}
	@Override
	public List<Restaurant> getRestaurantListByCategory(String category1, String category2, String sortType){
		return restaurantDao.getRestaurantListByCategory(category1, category2, sortType);
	}
	@Override
	public List<Restaurant> searchRestaurantList(String keywords) {
		return restaurantDao.searchRestaurantList(keywords);
	}
	@Override
	public Restaurant getRestaurantByUserId(String userId) {
		return restaurantDao.getRestaurantByOwnerId(userId);
	}
	@Override
	public Restaurant getRestaurantByResId(String resId) {
		return restaurantDao.getRestaurant(resId);
	}
	
	
	//Food
	@Override
	public List<Food> getFoodListByRestaurant(String resId) {
		return foodDao.getFoodListByResId(resId);
	}
	@Override
	public void insertFood(Food food) {
		foodDao.insertFood(food);
	}
	@Override
	public void updateFood(Food food) {
		foodDao.updateFood(food);
	}
	@Override
	public void deleteFood(String foodId) {
		foodDao.deleteFood(foodId);
	}
	
	@Override
	public Food getFood(String foodId) {
		return foodDao.getFood(foodId);
	}

	//Food Order
	@Override
	@Transactional
	public void insertFoodOrder(FoodOrder order) {
		String newOrderId;
		//주문 하나의 주문자정보
		orderInfoDao.insertFoodOrderInfo(order); //foodId는 그냥 맨 처음 대표적인 list[0]로 foodId 넣음.
		//주문 하나의 예약정보
		newOrderId = "fo" + orderInfoDao.getRecentOrderId();
		foodOrderDao.insertFoodOrder(order, newOrderId);
		
		
		//카트 item들 모두 넣기
		for(FoodCartItem val : order.getFoodList()) {
			FoodLineItem item = new FoodLineItem(newOrderId, val.getFood().getFoodId(), val.getQuantity(), val.getUnitPrice());
			foodLineItemDao.insertFoodLineItem(item);
		}
		
	}
	public void deleteFoodOrder(String orderId) {
		//orderinfo - foodorder - foodlineitme 종속삭제
		orderInfoDao.deleteFoodOrderInfo(orderId);
	}
	@Override
	public FoodOrder getFoodOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<FoodOrder> getFoodOrdersByUserId(String userId) {
		List<FoodOrder> orderList = orderInfoDao.getOrdersByUserId(userId);
		for(FoodOrder order : orderList) {
			List<FoodLineItem> orderedItemList = foodLineItemDao.getFoodLineItemByOrderId(order.getOrderId());
			for(FoodLineItem orderedItem : orderedItemList) {
				String foodName = foodDao.getFood(orderedItem.getFoodId()).getName();
				orderedItem.setFoodName(foodName);
			}
			order.setOrderedList(orderedItemList);
		}
		
		return orderList;
	}
	//FoodReview
	public List<FoodReview> getFoodReviewListByResId(String resId, String sortType) {
		return foodReviewDao.getFoodReviewListByResId(resId, sortType);
	}
	
	public void insertFoodReview(FoodReview foodReview) {
		foodReviewDao.insertFoodReview(foodReview);
	}
	@Override
	public void updateAvgRating(int rating, String resId) {
		restaurantDao.updateAvgRating(rating, resId);
	}
  
	//together
	@Override
	public Together getTogetherByTogId(String togId) {
		return togetherDao.getTogetherByTodId(togId);
	}
	
	@Override
	public List<Together> getTogetherList() {
		return togetherDao.getTogetherList();
	}
	
	@Override
	public void insertTogether(Together together) {
		togetherDao.insertTogether(together);
	}
	
	@Override
	public List<Together> getTogetherListByCategory(String area, String date, String kind, int price, String sex, String age) {
		return togetherDao.getTogetherListByCategory(area, date, kind, price, sex, age);
	}
	
	@Override
	public void updateTogether(Together together) {
		togetherDao.updateTogether(together);
	}
	
	@Override
	public List<Together> recommandTogetherList(String sex, String address) {
		return togetherDao.recommandTogetherList(sex, address);
	}
	
	@Override
	public List<Together> getTogetherListByResId(String resId) {
		return togetherDao.getTogetherListByResId(resId);
	}
	
	@Override
	public void deleteTogether(String togId) throws DataAccessException {
		togetherDao.deleteTogether(togId); 
  }
  
  @Override
	public List<Together> searchTogetherList(String keyword) {
		return togetherDao.searchTogetherList(keyword);
	}
	
	//TogetherFood
	@Override
	public List<TogetherFood> getTogetherFoodListByTogId(String togId) {
		return togetherFoodDao.getTogetherFoodListByTogId(togId);
	}
	
	@Override
	public void insertTogetherFood(TogetherFood togetherFood) {
		togetherFoodDao.insertTogetherFood(togetherFood);
	}
	
	@Override
	public void deleteTogetherFood(String togId) {
		togetherFoodDao.deleteTogetherFood(togId);
	}
	
	@Override
	public void updateTogetherFood(TogetherFood togetherFood) {
		togetherFoodDao.updateTogetherFood(togetherFood);
	}
	
	//TogetherMember
	@Override
	public List<TogetherMember> getTogetherMemberListByTogId(String togId) {
		return togetherMemberDao.getTogetherMemberListByTogId(togId);
	}
	
	@Override
	public void insertTogetherMember(TogetherMember togetherMember) {
		togetherMemberDao.insertTogetherMember(togetherMember);
	}
	
	@Override
	public void deleteTogetherMember(String togId) {
		togetherMemberDao.deleteTogetherMember(togId);
	}
	
	//TogetherOrder
	@Override
	public void insertTogetherOrder(TogetherOrder togetherOrder) {
		togetherOrderDao.insertTogetherOrder(togetherOrder);
	}
	
	@Override
	public void insertTogetherOrderInfo(Order order) {
		orderInfoDao.insertTogetherOrderInfo(order);
	}
	
	@Override
	public void insertFoodOrderForTogetherOrder(FoodOrder foodOrder) {
		foodOrderDao.insertFoodOrderForTogetherOrder(foodOrder);
	}
	
	@Override
	public List<TogetherOrder> getTogetherOrderByUserId(String userId) {
		return togetherOrderDao.getTogetherOrderByUserId(userId);
	}

	@Override
	public List<TogetherOrder> getTogetherOrderByTogId(String togId) {
		// TODO Auto-generated method stub
		return togetherOrderDao.getTogetherOrderByTogId(togId);
	}

	@Override
	public void deleteTogetherOrder(String togId) {
		togetherOrderDao.deleteTogetherOrder(togId);
	}

	@Override
	public void deleteTogetherOrderInfo(String orderId) {
		orderInfoDao.deleteTogetherOrderInfo(orderId);
	}

	@Override
	public void updateTogetherOrderInfo(Order order) {
		orderInfoDao.updateTogetherOrderInfo(order);
	}

}