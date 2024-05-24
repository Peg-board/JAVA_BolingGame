/**
 * 20191426 김성진
 */
import junit.framework.TestCase;

public class TestGame extends TestCase {
    public TestGame(String name){
        super(name);
    }

    private Game g;

    public void setUp(){
        g = new Game();
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

    public void testFourThrowsNoMark(){ // 스페어가 없는 4개의 투구, 프레임별 점수 테스트
        Game g = new Game();
        g.add(5); // 첫번째 투구
        g.add(4); // 두번째 투구
        g.add(7); // 세번째 투구
        g.add(2); // 네번째 투구
        assertEquals(18,g.score()); // 전체 점수 테스트
        assertEquals(9, g.scoreForFrame(1)); // 프레임별 점수 테스트
        assertEquals(18, g.scoreForFrame(2)); // 프레임별 점수 테스트
    }

    public void testSimpleSpare(){ // 스페어를 처리하는 3개의 투구
        g.add(3); // 첫번째 투구
        g.add(7); // 두번째 투구
        g.add(3); // 세번째 투구
        assertEquals(13, g.scoreForFrame(1)); // 프레임별 점수 테스트(스페어)
    }

    public void testSimpleFrameAfterSpare(){ // 스코어 함수 테스트 TODO: 실패
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13, g.scoreForFrame(1));
        assertEquals(18, g.score());
    }

}
