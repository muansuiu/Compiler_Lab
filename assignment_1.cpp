#include<bits/stdc++.h>
using namespace std;

void checkID()
{
    char id[100];

    scanf("%s", id);

    int i;
    int n = strlen(id);

    int temp1 = 0, temp2 = 0, temp3 = 0,temp4 = 0, temp5=0,temp6=0,temp7=0;



    for(i = 0; id[i] != '\0'; i++ )
    {
        if(id[0] == '0' && id[1] == '1' && id[2] == '1')
        {
            temp1++;
        }

        if(id[3] == '0' || id[3] == '1' || id[3] == '2')
        {
            temp2++;
        }

        if(id[4] >= 48 && id[4] <= 57)
        {
            temp3++;
        }

        if(id[5] == '1' || id[5] == '2' || id[5] == '3')
        {
            temp4++;
        }

        if(id[6] >= 48 && id[6] <= 57)
        {
            temp5++;
        }

        if(id[7] >= 48 && id[7] <= 57)
        {
            temp6++;
        }

        if(id[8] >= 48 && id[8] <= 57)
        {
            temp7++;
        }

        if(id[7] == 48 && id[8] == 48 && id[6] == 48 )
        {
            temp5 = 0;
            temp6 = 0;
            temp7 = 0;
        }
    }

    if(temp1 && temp2 && temp3 && temp4 && temp5 && temp6 && temp7)
    {
        printf("---------------------------------Accepted---------------------------------");
    }

    else
    {
            printf("-------------------------Not Accepted-------------------------------");
    }
}


void checkComplex()
{
    char a[10];

    fflush(stdin);
    gets(a);

    int i, index ,Count = 0;

    for(i = 0; a[i] != '\0'; i++)
    {
        if(a[i]== '+')
        {
            index = i;
        }
    }

    for(i = index; a[i] != '\0'; i++)
    {
        if(a[i] == 'i')
        {
            Count++;
        }
    }

    if(Count == 1)
    {
        printf("------------------Accepted----------------------");

    }

    else
        printf("------------------Not Accepted------------------");

}

void checkString()
{
    char Str[100];

    fflush(stdin);
    gets(Str);

    int i;

    int count1 = 0, count2 = 0, count3 = 0;

    int n = strlen(Str);

    if(n >=3)

    {


        for(i = 0; i < n;  i++)
        {
            if( isdigit(Str[0]))
            {
                count1++;
            }

            if( isupper(Str[1]))
            {
                count2++;
            }

            if( !isalpha(Str[2]) )
            {
                count3++;
            }


        }
    }

        if( count1 && count2 && count3)
        {
            printf("---------------------------- Accepted--------------------");
        }

        else
        {
            printf("-------------------------Not Accepted-----------------");
        }

}

void checkInt()
{
    char num[100];

    fflush(stdin);
    gets(num);

    int i,count1 =0,count2 = 0,count3 =0;

    for(i = 0; num[i] !='\0';  i++)
    {
        if( isalpha(num[i]))
        {
            count1++;
        }

        if( num[i] == '+' || num[i] == '-' )
        {
            count2++;
        }

        if(num[i] == '.')
        {
            count3++;
        }
    }

    printf("%d", count1);

    if(count1 >0 || count2 >1 || count3 > 1 || num[i-1] == '.')
    {
        printf("---------------------Not Accepted------------------------");
    }

    else
    {
        printf("----------------------- Accepted -----------------------------");
    }


}


void checkPassword()
{
    char password[100];



    scanf("%s", password);

    int j,temp1=0,temp2=0,temp3=0,temp4=0;

    int n = strlen(password);



    if(n >= 8)
    {
        for(j = 0; password[j] != '\0'; j++)
        {
            if(isupper(password[j]))
            {
                temp1++;
            }

            if(islower(password[j]))
            {
                temp2++;
            }

            if(isdigit(password[j]))
            {
                temp3++;
            }

        }
        if(password[n-1] == '@' || password[n-1] == '#' || password[n-1]== '$' || password[n-1] == '&')
        {
            temp4++;
        }
    }

    if(temp1 && temp2 && temp3 && temp4)
    {
        printf("------------------Accepted---------------");
    }

    else
    {
        printf("-----------------Not Accepted--------------");
    }

}


int main()
{
    int exit = 0;

    while(exit == 0)
    {
        int choice;

        printf("\n          Enter Your Choice:");
        printf("\n          1.Check ID");
        printf("\n          2.Check Complex Number");
        printf("\n          3.Check String");
        printf("\n          4.Check Integer/Floating Number");
        printf("\n          5.Check Password\n");

        scanf("%d", &choice);

        if(choice == 1)
        {
            checkID();
        }

        else if(choice == 2)
        {
            checkComplex();
        }

        else if(choice == 3)
        {
            checkString();
        }

        else if(choice == 4)
        {
            checkInt();
        }

        else if(choice == 5)
        {
            checkPassword();
        }

    printf("\n      Enter 0 to Continue         ");
    scanf("%d",  &exit);

    }


}


