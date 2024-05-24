/**
 * 20191426 김성진
 */
import junit.framework.TestCase;

public class TestFrame extends TestCase {
    public TestFrame(String name){
        super(name);
    }

    public void testScoreNoThrows(){
        Frame f = new Frame(); // 객체생성
        f.add(5);
        assertEquals(5, f.getScore()); // 값이 반환되는지 확인
    }

}
