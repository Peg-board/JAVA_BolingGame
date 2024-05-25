/**
 * 20191426 김성진
 */
public class Game { // 게임을 나타내는 객체, Frame을 연결 리스트로 갖기위해 생성
    public int score(){ // 전체 점수를 반환하는 함수
        return scoreForFrame(itsCurrentFrame);
    }

    public int getCurrentFrame(){
        return itsCurrentFrame;
    }


    public void add(int pins){ // 인자: 쓰러뜨린 핀의 개수
        itsScorer.addThrow(pins);
        /**itScore += pins; // 전체 점수 누계*/
        adjustCurrentFrame(pins);

    }

    private void adjustCurrentFrame(int pins){
        // 스트라이크 || 두번째 투구 -> 다음 프레임, 첫번째 투구
        if(lastBallInFrame(pins)){
            advanceFrame();
            firstThrowInFrame = true;
        }
        // 첫번째 투구(노 스트라이크) -> 두번째 투구
        else
            firstThrowInFrame = false;
    }
    private boolean strike(int pins){
        return (firstThrowInFrame && pins == 10);
    }
    private boolean lastBallInFrame(int pins){
        return strike(pins) || !firstThrowInFrame;
    }


    private boolean adjustFrameForStrike(int pins){
        if(pins == 10){
            advanceFrame();
            return true;
        }
        return false;
    }

    private void advanceFrame(){
        itsCurrentFrame = Math.min(10, itsCurrentFrame+1); // 최대 프레임 제한, 11: score 함수는 getCurrentFrame에서 1을 뺸다.
    }

    public int scoreForFrame(int theFrame){ // 프레임별 점수를 계산하여 반환하는 함수
        return itsScorer.scoreForFrame(theFrame);
    }

    /**private int itsScore = 0;*/
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private Scorer itsScorer = new Scorer();

}
