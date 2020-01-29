package online_store_group_project;

public class Rating {
	
	private Item item;
	private float score;
	private String review;
	
	
	//CONSTRUCTORS
	public Rating(Item item) {
		this.item = item;
		this.score = 0;
		this.review = "";
	}
	
	public Rating(Item item, float score, String review) {
		this.item = item;
		this.score = score;
		this.review = review;
	}
	
	
	public void setReview(String review) {
		this.review = review;
	}
	
	public String getReview() {
		return this.review;
	}
	
	public void setScore(float score) {
		this.score = score;
	}
	
	public float getScore() {
		return this.score;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return this.item;
	}
}
