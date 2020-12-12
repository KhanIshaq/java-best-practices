package generics;
/**
 * 
 * @author ishaqkhan
 *
 * Class has unchecked or unsafe operations
 * 
 * Note: Recompile with -Xlint:unchecked for details.
 */
public class WarningDemo {
	
    @SuppressWarnings("unchecked")
	public static void main(String[] args){
        Box<Integer> bi;
        bi = createBox();
    }

    static Box createBox(){
        return new Box();
    }
}