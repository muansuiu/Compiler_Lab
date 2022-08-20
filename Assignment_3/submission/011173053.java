//Name: Mubin Uddin Ahmed Nezami
//ID: 011 173 053

import java.io.*;
import java.util.Scanner;
import java.util.Stack;


public class Main
{
    static int checkOperator(char flag)
    {
        if (flag >= 'A' && flag <= 'Z')
            return 0;

        else if (flag >= 'a' && flag <= 'z')
            return 0;

        else if (flag >= '0' && flag <= '9')
            return 0;

        else return 1;
    }

    static int checkPriority(char flag)
    {
        if (flag == '+' || flag == '-')
            return 1;

        else if (flag == '*' || flag == '/')
            return 2;

        else if (flag == '^')
            return 3;

        else
            return 0;
    }

    static String infix_to_prefix(String input)
    {
        Stack<Character> operators = new Stack<>();
        Stack<String> operands = new Stack<>();
        int i;

        for (i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                operators.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                while (!operators.empty() &&
                        operators.peek() != '(') {
                    String operand1 = operands.peek();
                    operands.pop();


                    String operand2 = operands.peek();
                    operands.pop();

                    char op = operators.peek();
                    operators.pop();

                    String tmp = op + operand2 + operand1;
                    operands.push(tmp);
                }

                operators.pop();
            } else if (checkOperator(input.charAt(i)) != 1) {
                operands.push(input.charAt(i) + "");
            } else {
                while (!operators.empty() && checkPriority(input.charAt(i)) <= checkPriority(operators.peek())) {
                    String op1 = operands.peek();
                    operands.pop();

                    String op2 = operands.peek();
                    operands.pop();

                    char op = operators.pop();

                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }
                operators.push(input.charAt(i));
            }
        }

        while (!operators.empty())
        {
            String op1 = operands.peek();
            operands.pop();

            String op2 = operands.peek();
            operands.pop();

            char op = operators.peek();
            operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }

        return operands.peek();
    }

    static String infix_to_postfix(String input)
    {
        Stack<Character> stack = new Stack<>();
        String result = "";
        int i;
        char flag;

        for (i = 0; i < input.length(); i++)
        {
            flag = input.charAt(i);

            if (checkOperator(flag) != 1)
            {
                result += flag;
            }

            else if (flag == '(')
            {
                stack.push(flag);
            }

            else if (flag == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                {
                    result += stack.pop();
                }

                stack.pop();
            }

            else
            {
                while (!stack.isEmpty() && checkPriority(flag) <= checkPriority(stack.peek()))
                {
                    result += stack.pop();
                }
                stack.push(flag);
            }
        }

        while (!stack.isEmpty())
        {
            result += stack.pop();
        }
        return result;

    }


    static void input()
    {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter Infix Input:");
        String input = s1.nextLine();

        System.out.println("Enter 1 for Prefix Conversion:");
        System.out.println("Enter 2 for Postfix Conversion:");
        
        String result = null;

        int a = s1.nextInt();
        if( a == 1)
        {
            System.out.println("Infix to Prefix:");
            result = infix_to_prefix(input);
        }

        else if (a == 2)
        {
            System.out.println("Infix to Postfix:");
            result = infix_to_postfix(input);
        }

        System.out.println(result);
        System.out.println("");
    }

    static void File_Input() throws IOException
    {
        String input="";
        try
        {
            System.out.println("Enter Input to link File");
            FileWriter fw1 = new FileWriter("D:\\Study\\8th Trimester\\Compiler LAB\\Assignment_3\\infix_input.txt");
            Scanner ss = new Scanner(System.in);
            input = ss.nextLine();
            fw1.write(input);
            fw1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader file = new FileReader("D:\\Study\\8th Trimester\\Compiler LAB\\Assignment_3\\infix_input.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
        {
            input = sc.nextLine();
        }
        System.out.println("Enter 1 for Prefix Conversion:");
        System.out.println("Enter 2 for Postfix Conversion:");

        String result = null;
        Scanner s1 = new Scanner(System.in);

        int a = s1.nextInt();
        if( a == 1)
        {
            System.out.println("Infix to Prefix:");
            result = infix_to_prefix(input);
        }

        else if (a == 2)
        {
            System.out.println("Infix to Postfix:");
            result = infix_to_postfix(input);
        }

        try
        {
            FileWriter fw = new FileWriter("D:\\Study\\8th Trimester\\Compiler LAB\\Assignment_3\\infix_input.txt");
            assert result != null;
            fw.write("\n"+result);
            System.out.println("----------Check result in file-------------");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args) throws IOException {
        System.out.println("Name: Mubin Uddin Ahmed Nezami");
        System.out.println("ID: 011 173 053 \n\n");
        int choice = 0;
        Scanner sc = new Scanner(System.in);


        while(choice !=3)
        {
            System.out.println("Enter Your Choice");
            System.out.println("1.Console Input");
            System.out.println("2.File Input");
            System.out.println("3.Exit");
            choice = sc.nextInt();
            if ( choice == 1)
            {
                input();
            }

            else if (choice == 2)
            {
                File_Input();
            }

            else if (choice == 3)
            {
                System.out.println("Exit");
            }
        }

    }
}
