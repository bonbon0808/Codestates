package com.codestates.seb.calculator;
import java.util.Scanner;

public class Calculator {


  public static void main(String[] args) {
    System.out.println("===Java Calculator===");


    while (true) {
      double num1 = 0;
      double num2 = 0;
      double sum = 0;
      char operator = '\0';


      Scanner input = new Scanner(System.in);
      System.out.print("첫 번째 숫자 : ");
      num1 = input.nextDouble();
      System.out.print("연산자(+,-,*,/) : ");
      operator = input.next().charAt(0);
      System.out.print("두 번째 숫자 : ");
      num2 = input.nextDouble();

      switch (operator) {
        case '+':
          sum = num1 + num2;
          break;
        case '-':
          sum = num1 - num2;
          break;
        case '*':
          sum = num1 * num2;
          break;
        case '/':
          sum = num1 / num2;
          break;
        default:
          System.out.print("잘못된 입력입니다.");
          return;

      }


      System.out.println(num1 + " " + operator + " " + num2 + " = " + sum);


      // Scanner로 사용자 입력 받기
      // 첫 번째 숫자 변수 , 연산자 입력받을 변수, 두 번째 숫자 변수, 연산한 결과를 넣어 놓을 변수
      // double이나 float 3개, char 1개,
      // double , float
      // 출력 println()
      // 연산자 입력 + - * /
      // + 어떠한 기능을 하는지 정해줘야 (switch문으로)
      // 반복하려면 while로 묶어주기 -> 그러면 거짓일 때까지 반복


        /*
            요구 사항에 따라 간단한 계산기를 만들어주세요.
            1. 사용자의 입력으로 첫 번째 숫자, 연산자, 두 번째 숫자를 받아야 합니다.
            2. 연산자의 종류는 +, -, *, / 입니다.
            3. 소수점 연산을 수행할 수 있어야 합니다.
            4. 연산 결과를 콘솔에 출력합니다.
        */


    }
  }
}

