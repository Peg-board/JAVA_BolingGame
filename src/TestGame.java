/**
 * 20191426 김성진
 */
import junit.framework.TestCase;

public class TestGame extends TestCase {
    public TestGame(String name){
        super(name);
    }

    public void testOneThrow(){ // 하나의 투구
        Game g = new Game(); // 객체 생성
        g.add(5); // 첫번째 투구
        assertEquals(5, g.score());
    }

    public void testTwoThrowsNoMark(){ // 스페어가 없는 2개의 투구
        Game g = new Game(); // 객체 생성
        g.add(5); // 첫번째 투구
        g.add(4); // 두번째 투구
        assertEquals(9, g.score());

    }

}
