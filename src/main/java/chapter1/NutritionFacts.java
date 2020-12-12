package chapter1;

/**
 * 
 * @author ishaqkhan
 *	Builder Pattern
 *	Client calls Static Factory method with the required parameters & call the setter method which gets the Builder Object
 *  Finally client calls the parameterless method build to generate the object
 */
public class NutritionFacts {
	
	private final int servingSize;	
	private final int servings;		
	private final int calories;		
	private final int fat;			
	private final int sodium;		
	private final int carbohydrate;

	public static class Builder{
		//Required Parameters
		private final int servingSize;	
		private final int servings;		
		
		//Optional Parameters - initialized to default value
		private int calories = 0;		
		private int fat = 0;			
		private int sodium = 0;		
		private int carbohydrate = 0;
		
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val) {
			calories = val;
			return this;
		}
		
		public Builder fat(int val) {
			fat = val;
			return this;
		}
		
		public Builder sodium(int val) {
			sodium = val;
			return this;
		}
		
		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}
		
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}
	
	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
}

//Instance
//NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
//											.calories(20)
//											.fat(40)
//											.sodium(6)
//											.carbohydrate(100)
//											.build();
