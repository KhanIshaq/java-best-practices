/**
 * 
 */
package chapter1;

/**
 * @author ishaqkhan
 * Telescopic Constructor Example
 * 
 */
public class TelescopicNutritionFacts {

	private int servingSize;	//(mL) required
	private int servings;		//(container) required
	private int calories;		//optional
	private int fat;			//optional
	private int sodium;			//optional
	private int carbohydrate;	//optional
	
	public TelescopicNutritionFacts(int servingSize, int servings) {
		this(servingSize,servings, 0);
	}
	
	public TelescopicNutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize,servings, calories, 0);
	}
	
	public TelescopicNutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize,servings, calories, fat, 0);
	}
	
	public TelescopicNutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
		this(servingSize,servings, calories, fat, sodium, 0);
	}
	
	public TelescopicNutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}
}

//Instance 
//TelescopicNutritionFacts cocaCola = new TelescopicNutritionFacts(240, 8, 100, 0, 35, 27);
