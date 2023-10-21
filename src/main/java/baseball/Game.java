package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Computer computer;

    private final String GAME_START="숫자 야구 게임을 시작합니다.";
    private final String GAME_END="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String GAME_CONTINUE="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String WRONG_INPUT="입력값이 올바르지 않습니다.";

    public Game(Computer computer) {
        this.computer = computer;
    }

    private static class LazyHolder{
        public static final Game INSTANCE=new Game(Computer.getInstance());
    }

    public static Game getInstance(){
        return LazyHolder.INSTANCE;
    }

    private void printGameStart(){
        System.out.println(GAME_START);
    }

    private void printGameEnd(){
        System.out.println(GAME_END);
    }

    private void printResult(int ball, int strike){
        if(ball==0 && strike==0){
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb=new StringBuilder();
        if(ball>0)
            sb.append(ball).append("볼").append(" ");

        if(strike>0)
            sb.append(strike).append("스트라이크");

        System.out.println(sb);
    }

    private boolean getGameContinueInput(){
        System.out.println(GAME_CONTINUE);
        String input = Console.readLine().trim();
        Integer value;

        try{
            value=Integer.valueOf(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(WRONG_INPUT);
        }

        if(value!=1 || value!=2)
            throw new IllegalArgumentException(WRONG_INPUT);

        return value==1;
    }

}
