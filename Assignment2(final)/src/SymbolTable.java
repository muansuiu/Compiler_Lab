import java.util.Scanner;

public class SymbolTable
{
    static int count=0;
    static void insert(int i,String[][] table)
    {

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        if(input.contains(";"))
        {
            String[] input1 = input.split(";");

            table[i][0] = Integer.toString(i);
            if(!input.contains(","))
            {
                table[i][0] = Integer.toString(i);
                String[] str1 = input1[0].split(" ");
                if(str1[0].equals("int"))
                {
                    table[i][2] = str1[0];
                }
                else if(str1[0].equals("float"))
                {
                    table[i][2] = str1[0];
                }
                else if(str1[0].equals("double"))
                {
                    table[i][2] = str1[0];
                }

                if(str1[1].contains("="))
                {
                    String[] str2 = str1[1].split("=");

                    table[i][1] = str2[0];
                    table[i][3] = str2[1];
                }
                else
                {
                    table[i][1] = str1[1];
                }

            }
            else
            {
                count++;
                String[] cs1 = input1[0].split(",");
                String[] cs2 = cs1[0].split(" ");
                table[i][2] = cs2[0];
                table[i+1][2] = cs2[0];
                table[i+1][0] = Integer.toString(i+1);
                if(cs2[1].contains("="))
                {
                    String[] cs3 = cs2[1].split("=");
                    table[i][1] = cs3[0];
                    table[i][3] = cs3[1];
                }
                else
                {
                    table[i][1] = cs2[1];
                }

                if(!cs1[1].contains("="))
                {
                    table[i+1][1] = cs1[1];

                }

                else
                {
                    String[] cs4 = cs1[1].split("=");
                    table[i+1][1] = cs4[0];
                    table[i+1][3] = cs4[1];
                }


            }


        }

        //show table
        int j;
        table[0][0] = "Serial";
        table[0][1] = "Name";
        table[0][2] = "Type";
        table[0][3] = "Value";

        for(int m = 0; m < 1 ; m++)
        {
            for(j = 0; j < 4; j++)
            {
                System.out.print(table[m][j]+"     ");
            }
        }
        int k = i;
        for(; i < k+1; i++)
        {
            System.out.println("");
            for (j = 0; j < 4; j++)
            {
                System.out.print("     ");
                System.out.print(table[i][j] );
            }
            System.out.println("");
        }





    }

    static void showTable(String[][] table,int count)
    {
        int i,j;
        table[0][0] = "Serial";
        table[0][1] = "Name";
        table[0][2] = "Type";
        table[0][3] = "Value";

        for(i = 0; i < 1 ; i++)
        {
            for(j = 0; j < 4; j++)
            {
                System.out.print(table[i][j]+"     ");
            }
        }

        for(i = 1; i <= count; i++)
        {
            System.out.println("");
            for(j = 0; j < 4; j++)
            {
                System.out.print(" "+table[i][j]+"         ");
            }
            System.out.println("");


        }

    }


    static void find(String[][] table)
    {
        Scanner f = new Scanner(System.in);
        System.out.println("Enter serial no:");
        int serial = f.nextInt();
        int j;
        for(j = 0; j < 4; j++)
        {
            System.out.print(" "+table[serial][j]+"         ");
        }
        System.out.println("");
    }

    static void delete(String[][] table)
    {
        Scanner f = new Scanner(System.in);
        System.out.println("Enter serial no:");
        int serial = f.nextInt();
        int j;
        for(j = 0; j < 4; j++)
        {
            table[serial][j] = "-";
        }
    }

    static void update(String[][] table)
    {
        Scanner f = new Scanner(System.in);
        System.out.println("Enter serial no:");
        int serial = f.nextInt();
        insert(serial,table);

    }




    public static void main(String[] args)
    {
        int choice;
        String[][] table = new String[100][4];

        Scanner sc = new Scanner(System.in);


        int i,out=1,count = 0;
        for(i = 1; i < 20; i++)
        {
            if(out !=0)
            {
                System.out.println("Enter Choice");
                System.out.println("1.Insert");
                System.out.println("2.Find");
                System.out.println("3.Delete");
                System.out.println("4.Update");
                System.out.println("5.Show All");
                choice = sc.nextInt();
                if(choice == 1)
                {
                    insert(i,table);
                    count++;
                }

                else if(choice == 2)
                    find(table);
               else if(choice == 3)
                    delete(table);
                else if(choice == 4)
                    update(table);
                else if(choice == 5)
                    showTable(table,count);
                System.out.println("Enter 0 to exit");
                out = sc.nextInt();
            }

        }
    }
}
