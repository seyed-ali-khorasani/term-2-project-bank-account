package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class main
{
    static int jariAccNum=0;
    static int qarzolhassaneAccNum=0;
    static int sepordeAccNum=0;
    static int today=0,week=0,month=0;
    static Scanner input =new Scanner(System.in);
    public static void main(String [] args)
    {
        System.out.println("today is day 0 of week "+week+" of month "+month);
        boolean run=true;
        while (run)
        {
            System.out.println("which system do you want??   sabte ahval(1)  sabte asnad(2)  bank(3)  exit(4)  rob scenario(5)  change time(6)");
            int choose =input.nextInt();
            switch (choose)
            {
                case 1:
                {
                    sabteAhvalPanel();
                    break;
                }
                case 2:
                {
                    sabteAsnadPanel();
                    break;
                }
                case 3:
                {
                    bankPanel();
                    break;
                }
                case 4:
                {
                    run=false;
                    break;
                }
                case 5:
                {
                    try {
                        robScenario();
                    }
                    catch (IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6:
                {
                    System.out.println(time());
                }
            }
        }
    }
    static void sabteAhvalPanel()
    {
        System.out.println("which service do you want??  sign in person(1)  edit(2)  delete(3)  recover information(4)");
        int choose=input.nextInt();
        switch (choose)
        {
            case 1:
            {
                try
                {
                    System.out.println(signInSabteAhval());
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 2:
            {
                try {
                    System.out.println(editSabteAhval());
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 3:
            {
                try {
                    System.out.println(deleteSabteAhval());
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 4:
            {
                try {
                    System.out.println(recoverSabteAhval());
                }
                catch (IOException|ClassNotFoundException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    static String signInSabteAhval() throws IOException
    {
        System.out.println("please enter person name");
        String name=input.next();
        System.out.println("please enter person gender");
        String gender=input.next();
        System.out.println("please enter person national code");
        int nationalCode=input.nextInt();
        System.out.println("please enter person age");
        int age=input.nextInt();
        System.out.println("please enter person money");
        int money=input.nextInt();
        File file =new File(String.valueOf(nationalCode));
        Formatter formatter=new Formatter(file);
        formatter.format("%s\t%s\t%d\t%d\t%d",name,gender,nationalCode,age,money);
        formatter.close();
        return "succesful";
    }
    static String editSabteAhval() throws IOException
    {
        System.out.println("please enter person new name");
        String name=input.next();
        System.out.println("please enter person new gender");
        String gender=input.next();
        System.out.println("please enter person new national code");
        int nationalCode=input.nextInt();
        System.out.println("please enter person new age");
        int age=input.nextInt();
        System.out.println("please enter person new money");
        int money=input.nextInt();
        File file=new File(String.valueOf(nationalCode));
        if (!(file.exists())) return "not information found";
        else
        {
            Formatter formatter=new Formatter(file);
            formatter.format("%s\t%s\t%d\t%d\t%d",name,gender,nationalCode,age,money);
            formatter.close();
            return "succesful";
        }
    }
    static String deleteSabteAhval() throws IOException
    {
        System.out.println("please enter person national code who you want to delete");
        int nationalCode=input.nextInt();
        File file=new File(String.valueOf(nationalCode));
        if (!(file.exists())) return "this person is not exist";
        else
        {
            file.delete();
            return "succesfully deleted";
        }
    }
    static String recoverSabteAhval() throws IOException,ClassNotFoundException
    {
        System.out.println("please enter person national code who you want to recover info");
        int nationalCode=input.nextInt();
        File file=new File(String.valueOf(nationalCode));
        Scanner scanner=new Scanner(file);
        Person person=new Person(1,1,1,"","");
        person.setName(scanner.next());
        person.setGender(scanner.next());
        person.setNationalCode(scanner.nextInt());
        person.setAge(scanner.nextInt());
        person.setMoneyBag(scanner.nextInt());
        scanner.close();
        System.out.println("name:"+person.getName()+"  gender:"+person.getGender()+"  national code:"+person.getNationalCode());
        System.out.println("age:"+person.getAge()+"  money:"+person.getMoneyBag());
        return "succesfully";
    }
    static void sabteAsnadPanel()
    {
        System.out.println("which service do you want??  register property(1)  edit(2)  delete(3)  recover property information(4)");
        int choose=input.nextInt();
        switch (choose)
        {
            case 1:
            {
                try
                {
                    System.out.println(registerSabteAsnad());
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 2:
            {
                try {
                    System.out.println(editSabteAsnad());
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 3:
            {
                try {
                    System.out.println(deleteSabteAsnad());
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 4:
            {
                try {
                    System.out.println(recoverSabteAsnad());
                }
                catch (IOException|ClassNotFoundException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    static String registerSabteAsnad() throws IOException
    {
        System.out.println("please enter buy time");
        String buyTime=input.next();
        System.out.println("please enter address");
        String address=input.next();
        System.out.println("please enter owner national code");
        int nationalCode=input.nextInt();
        System.out.println("please enter property value");
        int value=input.nextInt();
        System.out.println("please enter property document code");
        int docCode=input.nextInt();
        File file =new File(String.valueOf(docCode));
        Formatter formatter=new Formatter(file);
        formatter.format("%s\t%s\t%d\t%d\t%d",buyTime,address,nationalCode,value,docCode);
        formatter.close();
        File file1=new File("documentCode");
        FileOutputStream fos=new FileOutputStream(file1,true);
        Formatter formatter1=new Formatter(fos);
        formatter1.format("%d\t",docCode);
        formatter1.close();
        File docCodeNumber=new File("docCodeNumber");
        if (!(docCodeNumber.exists()))
        {
            Formatter formatter2=new Formatter(docCodeNumber);
            docCodeNumber.createNewFile();
            formatter2.format("%d",1);
            formatter2.close();
        }
        else
        {
            Scanner scanner=new Scanner(docCodeNumber);
            int m=scanner.nextInt()+1;
            Formatter formatter2=new Formatter(docCodeNumber);
            formatter2.format("%d",m);
            formatter2.close();
        }
        return "succesful";
    }
    static String editSabteAsnad() throws IOException
    {
        System.out.println("please enter new buy time");
        String buyTime=input.next();
        System.out.println("please enter new address");
        String address=input.next();
        System.out.println("please enter new owner national code");
        int nationalCode=input.nextInt();
        System.out.println("please enter new property value");
        int value=input.nextInt();
        System.out.println("please enter new property document code");
        int docCode=input.nextInt();
        File file =new File(String.valueOf(docCode));
        if (!(file.exists())) return "not information found";
        else
        {
            Formatter formatter=new Formatter(file);
            formatter.format("%s\t%s\t%d\t%d\t%d",buyTime,address,nationalCode,value,docCode);
            formatter.close();
            return "succesful";
        }
    }
    static String deleteSabteAsnad() throws IOException
    {
        int value,ownerNationalCode;
        System.out.println("please enter property document code that you want to delete");
        int docCode=input.nextInt();
        File file =new File(String.valueOf(docCode));
        Scanner scanner=new Scanner(file);
        if (!(file.exists())) return "this property is not exist";
        else
        {
            scanner.next();
            scanner.next();
            ownerNationalCode=scanner.nextInt();
            value=scanner.nextInt();
            file.delete();
            File file1=new File(String.valueOf(ownerNationalCode));
            Scanner scanner1=new Scanner(file1);
            String name=scanner1.next();
            String gender=scanner1.next();
            int nationalCode=scanner1.nextInt();
            int age=scanner1.nextInt();
            value+=scanner1.nextInt();
            Formatter formatter =new Formatter(file1);
            formatter.format("%s\t%s\t%d\t%d\t%d",name,gender,nationalCode,age,value);
            formatter.flush();
            return "succesfully deleted";
        }
    }
    static String recoverSabteAsnad() throws IOException,ClassNotFoundException
    {
        System.out.println("please enter property document code that you want to recover info");
        int docCode=input.nextInt();
        File file =new File(String.valueOf(docCode));
        Scanner scanner=new Scanner(file);
        Property property=new Property(1,1,1,"","");
        property.setBuyTime(scanner.next());
        property.setPropertyAddress(scanner.next());
        property.setOwnerNationalCode(scanner.nextInt());
        property.setValue(scanner.nextInt());
        property.setDocumentCode(scanner.nextInt());
        scanner.close();
        System.out.println("buy time:"+property.getBuyTime()+"  address:"+property.getPropertyAddress()+"  owner national code:"+property.getOwnerNationalCode());
        System.out.println("value:"+property.getValue()+"  document code:"+property.getDocumentCode());
        return "succesfully";
    }
    static void bankPanel()
    {
        System.out.println("which service do you want??  create account(1)  deposit money(2)  withdraw money(3)");
        System.out.println("get bank cart(4)  get daste chek(5)  receive chek(6)  vam(7)");
        int choose=input.nextInt();
        switch (choose)
        {
            case 1:
            {
                System.out.println("which type of account do you want?? jari or qarzolhassane or seporde");
                try {
                    String select=input.next();
                    if (!select.equals("jari") && !select.equals("qarzolhassane") && !select.equals("seporde")) throw new InvalidType();
                    switch (select)
                    {
                        case "jari":
                        {
                            try {
                                System.out.println(createJariBankAccount());
                            }
                            catch (IOException e)
                            {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case "qarzolhassane":
                        {
                            try {
                                System.out.println(createQarzolhassaneBankAccount());
                            }
                            catch (IOException e)
                            {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case "seporde":
                        {
                            System.out.println("which type of acoount do you want?? (shortTime)  (longTime)  (special)");
                            String type=input.next();
                            try {
                                System.out.println(createSepordeBankAccount(type));
                            }
                            catch (IOException e)
                            {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
                catch (InvalidType e)
                {
                    System.out.println(e.message);
                }
                break;
            }
            case 2:
            {
                System.out.println("please enter your account number");
                int accNum=input.nextInt();
                System.out.println("what is your bank account type??  (jari)  (qarzolhassane)  (shortTime)  (longTime)  (special)");
                try {
                    String account = input.next();
                    if (!account.equals("jari") && !account.equals("qarzolhassane") && !account.equals("shortTime") && !account.equals("longTime") && !account.equals("special")) throw new InvalidType();
                    System.out.println("how much do you want to deposit??");
                    int deposit=input.nextInt();
                    try {
                        System.out.println("your mojodi is:"+depositMoney(accNum,account,deposit));
                    }
                    catch (IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                catch (InvalidType e)
                {
                    System.out.println(e.message);
                }
                break;
            }
            case 3:
            {
                System.out.println("please enter your account number");
                int accNum=input.nextInt();
                System.out.println("what is your bank account type??  (jari)  (qarzolhassane)  (shortTime)  (longTime)  (special)");
                try {
                    String account = input.next();
                    if (!account.equals("jari") && !account.equals("qarzolhassane") && !account.equals("shortTime") && !account.equals("longTime") && !account.equals("special")) throw new InvalidType();
                    System.out.println("how much do you want to withdraw??");
                    int withdraw=input.nextInt();
                    try {
                        System.out.println("your mojodi is:"+withdrawMoney(accNum,account,withdraw));
                    }
                    catch (IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                catch (InvalidType e)
                {
                    System.out.println(e.message);
                }
                break;
            }
            case 4:
            {
                System.out.println("please enter your account number");
                int accNum=input.nextInt();
                System.out.println("please enter your account type  (jari)  (qarzolhassane)");
                try
                {
                    String accType = input.next();
                    if (!accType.equals("jari") && !accType.equals("qarzolhassane")) throw new InvalidType();
                    BankCart bankCart = new BankCart(accNum);
                    try {
                        String message = bankCart.createBankCart(accNum, accType);
                        System.out.println(message);
                        if (message.equals("cart added")) {
                            if (accType.equals("jari")) {
                                JariBankAccount.bankCarts.add(bankCart);
                            } else if (accType.equals("qarzolhassane")) {
                                QarzolhassaneAccount.bankCarts.add(bankCart);
                            }
                        }
                    } catch (IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                catch (InvalidType e)
                {
                    System.out.println(e.message);
                }
                break;
            }
            case 5:
            {
                System.out.println("please enter your account number");
                int accNum=input.nextInt();
                DasteChek dasteChek=new DasteChek(accNum);
                try {
                    String message=dasteChek.createDasteChek(accNum);
                    System.out.println(message);
                    if (message.equals("daste chek added"))
                    {

                        JariBankAccount.dasteCheks.add(dasteChek);
                    }
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 6:
            {
                break;
            }
            case 7:
            {
                System.out.println("which type of vam do you want?? (6)qest  (12)qest");
                int vamMonths=input.nextInt();
                System.out.println("how much money do you want??");
                int vamValue=input.nextInt();
                System.out.println("please enter your account number");
                int accNumber=input.nextInt();
                System.out.println("please enter your account type  (jari)  (qarzolhassane)  (shortTime)  (longTime)  (special)");
                try {
                    String accType=input.next();
                    if (!accType.equals("jari") && !accType.equals("qarzolhassane") && !accType.equals("shortTime") && !accType.equals("longTime") && !accType.equals("special")) throw new InvalidType();
                    payVam(vamValue,accNumber,accType);
                }
                catch (InvalidType | IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    static String createJariBankAccount() throws IOException
    {
        File file=new File("jari");
        File jariAccNumber=new File("jariAccNumber");
        if (!(file.exists()))
        {
            file.createNewFile();
        }
        if (!(jariAccNumber.exists()))
        {
            jariAccNumber.createNewFile();
            Formatter formatter1=new Formatter(jariAccNumber);
            formatter1.format("%d",0);
            formatter1.flush();
        }
        FileOutputStream fos=new FileOutputStream (file,true);
        Formatter formatter =new Formatter(fos);
        System.out.println("please enter your national code");
        int nationalCode = input.nextInt();
        System.out.println("please enter account mojodi");
        int mojodi = input.nextInt();
        Scanner scanner=new Scanner(jariAccNumber);
        Scanner scanner1=new Scanner(file);
        jariAccNum=scanner.nextInt();
        for (int i=0;i<jariAccNum;i++)
        {
            System.out.println(scanner1.nextInt()+"  "+scanner1.nextInt()+"  "+scanner1.nextInt()+"  "+scanner1.next()+"  "+scanner1.nextInt());
        }
        System.out.println("your account number is:"+jariAccNum);
        formatter.format("%d\t%d\t%d\t%d\t%d\t",nationalCode,jariAccNum++,mojodi,today+(week*7)+(month*30),0);
        formatter.close();
        Formatter formatter1=new Formatter(jariAccNumber);
        formatter1.format("%d",jariAccNum);
        formatter1.close();
        return "jari account created";
    }
    static String createQarzolhassaneBankAccount() throws IOException
    {
        File file=new File("qarzolhassane");
        File qarzolhasseAccNumber=new File("qarzolhassaneAccNumber");
        if (!(file.exists()))
        {
            file.createNewFile();
        }
        if (!(qarzolhasseAccNumber.exists()))
        {
            qarzolhasseAccNumber.createNewFile();
            Formatter formatter1=new Formatter(qarzolhasseAccNumber);
            formatter1.format("%d",0);
            formatter1.flush();
        }
        FileOutputStream fos=new FileOutputStream (file,true);
        Formatter formatter =new Formatter(fos);
        System.out.println("please enter your national code");
        int nationalCode = input.nextInt();
        System.out.println("please enter account mojodi");
        int mojodi = input.nextInt();
        Scanner scanner=new Scanner(qarzolhasseAccNumber);
        Scanner scanner1=new Scanner(file);
        qarzolhassaneAccNum=scanner.nextInt();
        for (int i=0;i<qarzolhassaneAccNum;i++)
        {
            System.out.println(scanner1.nextInt()+"  "+scanner1.nextInt()+"  "+scanner1.nextInt()+"  "+scanner1.next()+"  "+scanner1.nextInt());
        }
        System.out.println("your account number is:"+qarzolhassaneAccNum);
        formatter.format("%d\t%d\t%d\t%d\t%d\t",nationalCode,qarzolhassaneAccNum++,mojodi,today+(week*7)+(month*30),0);
        formatter.flush();
        Formatter formatter1=new Formatter(qarzolhasseAccNumber);
        formatter1.format("%d",qarzolhassaneAccNum);
        formatter1.flush();
        return "qarzolhassane account created";
    }
    static String createSepordeBankAccount(String type) throws IOException
    {
        int benefitPercent=0,period=0;
        File file=new File("seporde");
        File sepordeAccNumber=new File("sepordeAccNumber");
        if (!(file.exists()))
        {
            file.createNewFile();
        }
        if (!(sepordeAccNumber.exists()))
        {
            sepordeAccNumber.createNewFile();
            Formatter formatter1=new Formatter(sepordeAccNumber);
            formatter1.format("%d",0);
            formatter1.flush();
        }
        FileOutputStream fos=new FileOutputStream (file,true);
        Formatter formatter =new Formatter(fos);
        System.out.println("please enter your national code");
        int nationalCode = input.nextInt();
        System.out.println("please enter account mojodi");
        int mojodi = input.nextInt();
        if (type.equals("shortTime"))
        {
            benefitPercent=10;period=10;
        }
        else if (type.equals("longTime"))
        {
            benefitPercent=30;period=30;
        }
        else if (type.equals("special"))
        {
            benefitPercent=50;period=50;
        }
        Scanner scanner=new Scanner(sepordeAccNumber);
        Scanner scanner1=new Scanner(file);
        sepordeAccNum=scanner.nextInt();
        for (int i=0;i<sepordeAccNum;i++)
        {
            System.out.println(scanner1.nextInt()+"  "+scanner1.nextInt()+"  "+scanner1.nextInt()+"  "+scanner1.next()+"  "+scanner1.nextInt()+"  "+scanner1.nextInt()+"  "+scanner1.nextInt()+"  "+scanner1.next());
        }
        System.out.println("your account number is:"+sepordeAccNum);
        formatter.format("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%s\t",nationalCode,sepordeAccNum++,mojodi,today+(week*7)+(month*30),0,benefitPercent,period,type);
        formatter.flush();
        Formatter formatter1=new Formatter(sepordeAccNumber);
        formatter1.format("%d",sepordeAccNum);
        formatter1.flush();
        return "seporde account created";
    }
    static int depositMoney(int accountNumber,String accountType,int deposit) throws IOException
    {
        ArrayList<JariBankAccount> jariBankAccounts=new ArrayList<>();
        ArrayList<QarzolhassaneAccount> qarzolhassaneAccounts=new ArrayList<>();
        ArrayList<SepordeAccount> sepordeAccounts=new ArrayList<>();
        int mojodi=10,check=-1,accNum;
        String accType="";
        if (accountType.equals("shortTime") || accountType.equals("longTime")|| accountType.equals("special"))
        {
            accType=accountType;
            accountType="seporde";
        }
        File file=new File(accountType);
        File file1=new File(accountType+"AccNumber");
        FileOutputStream fos=new FileOutputStream(file,true);
        Formatter formatter=new Formatter(fos);
        Scanner scanner=new Scanner(file);
        Scanner scanner1=new Scanner(file1);
        accNum=scanner1.nextInt();
        if (accountType.equals("jari") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                JariBankAccount jba=new JariBankAccount(0,0,0,0,0);
                jariBankAccounts.add(jba);
                jariBankAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                jariBankAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (jariBankAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else jariBankAccounts.get(i).setMojodi(scanner.nextInt());
                jariBankAccounts.get(i).setCreateTime(scanner.nextInt());
                jariBankAccounts.get(i).setNegativeScore(scanner.nextInt());
            }
            mojodi-=deposit;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {
                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", jariBankAccounts.get(i).getOwnerNationalCode(), jariBankAccounts.get(i).getAccountNumber(), jariBankAccounts.get(i).getMojodi(),
                            jariBankAccounts.get(i).getCreateTime(), jariBankAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", jariBankAccounts.get(i).getOwnerNationalCode(), jariBankAccounts.get(i).getAccountNumber(),
                            mojodi, jariBankAccounts.get(i).getCreateTime(), jariBankAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
            }
        }
        if (accountType.equals("qarzolhassane") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                QarzolhassaneAccount qba=new QarzolhassaneAccount(0,0,0,0,0);
                qarzolhassaneAccounts.add(qba);
                qarzolhassaneAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                qarzolhassaneAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (qarzolhassaneAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else qarzolhassaneAccounts.get(i).setMojodi(scanner.nextInt());
                qarzolhassaneAccounts.get(i).setCreateTime(scanner.nextInt());
                qarzolhassaneAccounts.get(i).setNegativeScore(scanner.nextInt());
            }
            mojodi-=deposit;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {
                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", qarzolhassaneAccounts.get(i).getOwnerNationalCode(), qarzolhassaneAccounts.get(i).getAccountNumber(), qarzolhassaneAccounts.get(i).getMojodi(),
                            qarzolhassaneAccounts.get(i).getCreateTime(), qarzolhassaneAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", qarzolhassaneAccounts.get(i).getOwnerNationalCode(), qarzolhassaneAccounts.get(i).getAccountNumber(),mojodi,
                            qarzolhassaneAccounts.get(i).getCreateTime(), qarzolhassaneAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
            }
        }
        if (accType.equals("shortTime") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
                sepordeAccounts.add(sba);
                sepordeAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                sepordeAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (sepordeAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else sepordeAccounts.get(i).setMojodi(scanner.nextInt());
                sepordeAccounts.get(i).setCreateTime(scanner.nextInt());
                sepordeAccounts.get(i).setNegativeScore(scanner.nextInt());
                sepordeAccounts.get(i).setBenefitPercent(scanner.nextInt());
                sepordeAccounts.get(i).setPeriod(scanner.nextInt());
                sepordeAccounts.get(i).setType(scanner.next());
            }
            if (today+(week*7)+(month*30)>=sepordeAccounts.get(check).getCreateTime()+sepordeAccounts.get(check).getPeriod())
            {
                mojodi=mojodi+(mojodi*sepordeAccounts.get(check).getBenefitPercent()/100);
            }
            mojodi-=deposit;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {
                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t", sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), sepordeAccounts.get(i).getMojodi(), sepordeAccounts.get(i).getCreateTime(),
                                                                         sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t",sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), mojodi, sepordeAccounts.get(i).getCreateTime(),
                                                                        sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
            }
        }
        if (accType.equals("longTime") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
                sepordeAccounts.add(sba);
                sepordeAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                sepordeAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (sepordeAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else sepordeAccounts.get(i).setMojodi(scanner.nextInt());
                sepordeAccounts.get(i).setCreateTime(scanner.nextInt());
                sepordeAccounts.get(i).setNegativeScore(scanner.nextInt());
                sepordeAccounts.get(i).setBenefitPercent(scanner.nextInt());
                sepordeAccounts.get(i).setPeriod(scanner.nextInt());
                sepordeAccounts.get(i).setType(scanner.next());
            }
            if (today+(week*7)+(month*30)>=sepordeAccounts.get(check).getCreateTime()+sepordeAccounts.get(check).getPeriod())
            {
                mojodi=mojodi+(mojodi*sepordeAccounts.get(check).getBenefitPercent())/100;
            }
            mojodi-=deposit;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {

                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t", sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), sepordeAccounts.get(i).getMojodi(), sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t",sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), mojodi, sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
            }
        }
        if (accType.equals("special") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
                sepordeAccounts.add(sba);
                sepordeAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                sepordeAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (sepordeAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else sepordeAccounts.get(i).setMojodi(scanner.nextInt());
                sepordeAccounts.get(i).setCreateTime(scanner.nextInt());
                sepordeAccounts.get(i).setNegativeScore(scanner.nextInt());
                sepordeAccounts.get(i).setBenefitPercent(scanner.nextInt());
                sepordeAccounts.get(i).setPeriod(scanner.nextInt());
                sepordeAccounts.get(i).setType(scanner.next());
            }
            if (today+(week*7)+(month*30)>=sepordeAccounts.get(check).getCreateTime()+sepordeAccounts.get(check).getPeriod())
            {
                mojodi=mojodi+(mojodi*sepordeAccounts.get(check).getBenefitPercent()/100);
            }
            mojodi-=deposit;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {

                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t", sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), sepordeAccounts.get(i).getMojodi(), sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t",sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), mojodi, sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
            }
        }
        return mojodi;
    }
    static int withdrawMoney(int accountNumber,String accountType,int withdraw) throws IOException
    {
        ArrayList<JariBankAccount> jariBankAccounts=new ArrayList<>();
        ArrayList<QarzolhassaneAccount> qarzolhassaneAccounts=new ArrayList<>();
        ArrayList<SepordeAccount> sepordeAccounts=new ArrayList<>();
        String accType="";
        if (accountType.equals("shortTime") || accountType.equals("longTime")|| accountType.equals("special"))
        {
            accType=accountType;
            accountType="seporde";
        }
        int mojodi=0,check=-1,accNum;
        File file=new File(accountType);
        File file1=new File(accountType+"AccNumber");
        FileOutputStream fos=new FileOutputStream(file,true);
        Formatter formatter=new Formatter(fos);
        Scanner scanner=new Scanner(file);
        Scanner scanner1=new Scanner(file1);
        Scanner scanner2 =new Scanner(file);
        accNum=scanner1.nextInt();
        if (accountType.equals("jari") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                JariBankAccount jba=new JariBankAccount(0,0,0,0,0);
                jariBankAccounts.add(jba);
                jariBankAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                jariBankAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (jariBankAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else jariBankAccounts.get(i).setMojodi(scanner.nextInt());
                jariBankAccounts.get(i).setCreateTime(scanner.nextInt());
                jariBankAccounts.get(i).setNegativeScore(scanner.nextInt());
            }
            mojodi+=withdraw;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {
                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", jariBankAccounts.get(i).getOwnerNationalCode(), jariBankAccounts.get(i).getAccountNumber(), jariBankAccounts.get(i).getMojodi(),
                            jariBankAccounts.get(i).getCreateTime(), jariBankAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", jariBankAccounts.get(i).getOwnerNationalCode(), jariBankAccounts.get(i).getAccountNumber(),
                            mojodi, jariBankAccounts.get(i).getCreateTime(), jariBankAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
            }
        }
        if (accountType.equals("qarzolhassane") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                QarzolhassaneAccount qba=new QarzolhassaneAccount(0,0,0,0,0);
                qarzolhassaneAccounts.add(qba);
                qarzolhassaneAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                qarzolhassaneAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (qarzolhassaneAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else qarzolhassaneAccounts.get(i).setMojodi(scanner.nextInt());
                qarzolhassaneAccounts.get(i).setCreateTime(scanner.nextInt());
                qarzolhassaneAccounts.get(i).setNegativeScore(scanner.nextInt());
            }
            mojodi+=withdraw;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {
                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", qarzolhassaneAccounts.get(i).getOwnerNationalCode(), qarzolhassaneAccounts.get(i).getAccountNumber(), qarzolhassaneAccounts.get(i).getMojodi(),
                            qarzolhassaneAccounts.get(i).getCreateTime(), qarzolhassaneAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", qarzolhassaneAccounts.get(i).getOwnerNationalCode(), qarzolhassaneAccounts.get(i).getAccountNumber(),mojodi,
                            qarzolhassaneAccounts.get(i).getCreateTime(), qarzolhassaneAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
            }
        }
        if (accType.equals("shortTime") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
                sepordeAccounts.add(sba);
                sepordeAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                sepordeAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (sepordeAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else sepordeAccounts.get(i).setMojodi(scanner.nextInt());
                sepordeAccounts.get(i).setCreateTime(scanner.nextInt());
                sepordeAccounts.get(i).setNegativeScore(scanner.nextInt());
                sepordeAccounts.get(i).setBenefitPercent(scanner.nextInt());
                sepordeAccounts.get(i).setPeriod(scanner.nextInt());
                sepordeAccounts.get(i).setType(scanner.next());
            }
            mojodi+=withdraw;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {

                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t", sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), sepordeAccounts.get(i).getMojodi(), sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t",sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), mojodi, sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
            }
        }
        if (accType.equals("longTime") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
                sepordeAccounts.add(sba);
                sepordeAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                sepordeAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (sepordeAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else sepordeAccounts.get(i).setMojodi(scanner.nextInt());
                sepordeAccounts.get(i).setCreateTime(scanner.nextInt());
                sepordeAccounts.get(i).setNegativeScore(scanner.nextInt());
                sepordeAccounts.get(i).setBenefitPercent(scanner.nextInt());
                sepordeAccounts.get(i).setPeriod(scanner.nextInt());
                sepordeAccounts.get(i).setType(scanner.next());
            }
            mojodi+=withdraw;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {

                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t", sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), sepordeAccounts.get(i).getMojodi(), sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t",sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), mojodi, sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
            }
        }
        if (accType.equals("special") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
                sepordeAccounts.add(sba);
                sepordeAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                sepordeAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (sepordeAccounts.get(i).getAccountNumber()==accountNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else sepordeAccounts.get(i).setMojodi(scanner.nextInt());
                sepordeAccounts.get(i).setCreateTime(scanner.nextInt());
                sepordeAccounts.get(i).setNegativeScore(scanner.nextInt());
                sepordeAccounts.get(i).setBenefitPercent(scanner.nextInt());
                sepordeAccounts.get(i).setPeriod(scanner.nextInt());
                sepordeAccounts.get(i).setType(scanner.next());
            }
            mojodi+=withdraw;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {

                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t", sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), sepordeAccounts.get(i).getMojodi(), sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t",sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), mojodi, sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
            }
        }
        return mojodi;
    }
    static void robScenario() throws IOException
    {
        ArrayList<JariBankAccount> jariBankAccounts=new ArrayList<>();
        ArrayList<QarzolhassaneAccount> qarzolhassaneAccounts=new ArrayList<>();
        ArrayList<SepordeAccount> sepordeAccounts=new ArrayList<>();
        ArrayList<Person> people=new ArrayList<>();
        ArrayList<Property> properties=new ArrayList<>();
        File jariBankAccFile=new File("jari");
        File jariBankAccNumFile=new File("jariAccNumber");
        File qarzolhassaneBankAccFile=new File("qarzolhassane");
        File qarzolhassaneBankAccNumFile=new File("qarzolhassaneAccNumber");
        File sepordeBankAccFile=new File("seporde");
        File sepordeBankAccNumFile=new File("sepordeAccNumber");
        File docCodeNumFile=new File("documentCode");
        File docCodeNumber=new File("docCodeNumber");
        Scanner docCodeNumberScanner=new Scanner(docCodeNumber);
        Scanner jariAccScanner=new Scanner(jariBankAccFile);
        Scanner jariAccNumScanner=new Scanner(jariBankAccNumFile);
        Scanner qarzolhassaneAccScanner=new Scanner(qarzolhassaneBankAccFile);
        Scanner qarzolhassaneAccNumScanner=new Scanner(qarzolhassaneBankAccNumFile);
        Scanner sepordeAccScanner=new Scanner(sepordeBankAccFile);
        Scanner sepordeAccNumScanner=new Scanner(sepordeBankAccNumFile);
        Scanner docCodeNumScanner=new Scanner(docCodeNumFile);
        int jariNum=jariAccNumScanner.nextInt();
        int qarzolhassaneNum=qarzolhassaneAccNumScanner.nextInt();
        int sepordeNum=sepordeAccNumScanner.nextInt();
        int docNum=docCodeNumberScanner.nextInt();
        for (int i=0;i<jariNum;i++)
        {
            JariBankAccount jba=new JariBankAccount(0,0,0,0,0);
            jba.setOwnerNationalCode(jariAccScanner.nextInt());
            jba.setAccountNumber(jariAccScanner.nextInt());
            jba.setMojodi(jariAccScanner.nextInt());
            jba.setCreateTime(jariAccScanner.nextInt());
            jba.setNegativeScore(jariAccScanner.nextInt());
            jariBankAccounts.add(jba);
        }
        for (int i=0;i<qarzolhassaneNum;i++)
        {
            QarzolhassaneAccount qba=new QarzolhassaneAccount(0,0,0,0,0);
            qba.setOwnerNationalCode(qarzolhassaneAccScanner.nextInt());
            qba.setAccountNumber(qarzolhassaneAccScanner.nextInt());
            qba.setMojodi(qarzolhassaneAccScanner.nextInt());
            qba.setCreateTime(qarzolhassaneAccScanner.nextInt());
            qba.setNegativeScore(qarzolhassaneAccScanner.nextInt());
            qarzolhassaneAccounts.add(qba);
        }
        for (int i=0;i<sepordeNum;i++)
        {
            SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
            sba.setOwnerNationalCode(sepordeAccScanner.nextInt());
            sba.setAccountNumber(sepordeAccScanner.nextInt());
            sba.setMojodi(sepordeAccScanner.nextInt());
            sba.setCreateTime(sepordeAccScanner.nextInt());
            sba.setNegativeScore(sepordeAccScanner.nextInt());
            sba.setBenefitPercent(sepordeAccScanner.nextInt());
            sba.setPeriod(sepordeAccScanner.nextInt());
            sba.setType(sepordeAccScanner.next());
            sepordeAccounts.add(sba);
        }
        for (int i=0;i<jariBankAccounts.size();i++)
        {
            Person person=new Person(0,0,0,"","");
            File personInfoFile=new File(String.valueOf(jariBankAccounts.get(i).getOwnerNationalCode()));
            Scanner personInfoScanner=new Scanner(personInfoFile);
            person.setName(personInfoScanner.next());
            person.setGender(personInfoScanner.next());
            person.setNationalCode(personInfoScanner.nextInt());
            person.setAge(personInfoScanner.nextInt());
            person.setMoneyBag(personInfoScanner.nextInt());
            people.add(person);
        }
        for (int i=0;i<qarzolhassaneAccounts.size();i++)
        {
            Person person=new Person(0,0,0,"","");
            File personInfoFile=new File(String.valueOf(qarzolhassaneAccounts.get(i).getOwnerNationalCode()));
            Scanner personInfoScanner=new Scanner(personInfoFile);
            person.setName(personInfoScanner.next());
            person.setGender(personInfoScanner.next());
            person.setNationalCode(personInfoScanner.nextInt());
            person.setAge(personInfoScanner.nextInt());
            person.setMoneyBag(personInfoScanner.nextInt());
            people.add(person);
        }
        for (int i=0;i<sepordeAccounts.size();i++)
        {
            Person person=new Person(0,0,0,"","");
            File personInfoFile=new File(String.valueOf(sepordeAccounts.get(i).getOwnerNationalCode()));
            Scanner personInfoScanner=new Scanner(personInfoFile);
            person.setName(personInfoScanner.next());
            person.setGender(personInfoScanner.next());
            person.setNationalCode(personInfoScanner.nextInt());
            person.setAge(personInfoScanner.nextInt());
            person.setMoneyBag(personInfoScanner.nextInt());
            people.add(person);
        }
        for (int i=0;i<docNum;i++)
        {
            File file=new File(String.valueOf(docCodeNumScanner.nextInt()));
            Scanner scanner=new Scanner(file);
            Property property=new Property(0,0,0,"","");
            property.setBuyTime(scanner.next());
            property.setPropertyAddress(scanner.next());
            property.setOwnerNationalCode(scanner.nextInt());
            property.setValue(scanner.nextInt());
            property.setDocumentCode(scanner.nextInt());
            properties.add(property);
        }
        for (int i=0;i<people.size();i++)
        {
            for (int j=0;j<people.size();j++)
            {
                if (j==i)
                {

                }
                if (i>=people.size() || j>=people.size()) break;
                else if (people.get(i).getNationalCode()==people.get(j).getNationalCode())
                {
                    people.remove(j);
                }
            }
        }
        for (int i=0;i<people.size();i++)
        {
            System.out.println("("+(i+1)+")  name:"+people.get(i).getName()+"  age:"+people.get(i).getAge()+"  gender:"+people.get(i).getGender()+"  national code:"+people.get(i).getNationalCode()+"  money bag:"+people.get(i).getMoneyBag());
            for (int j=0;j<jariBankAccounts.size();j++)
            {
                if (jariBankAccounts.get(j).getOwnerNationalCode()==people.get(i).getNationalCode())  System.out.println("jari account("+(j+1)+")  account number:"+jariBankAccounts.get(j).getAccountNumber()+"  mojodi:"+jariBankAccounts.get(j).getMojodi()+"  create time:"+jariBankAccounts.get(j).getCreateTime());
            }
            for (int j=0;j<qarzolhassaneAccounts.size();j++)
            {
                if (qarzolhassaneAccounts.get(j).getOwnerNationalCode()==people.get(i).getNationalCode())  System.out.println("qarzolhassane account("+(j+1)+")  account number:"+qarzolhassaneAccounts.get(j).getAccountNumber()+"  mojodi:"+qarzolhassaneAccounts.get(j).getMojodi()+"  create time:"+qarzolhassaneAccounts.get(j).getCreateTime());
            }
            for (int j=0;j<sepordeAccounts.size();j++)
            {
                if (sepordeAccounts.get(j).getOwnerNationalCode()==people.get(i).getNationalCode())  System.out.println("sepored account("+(j+1)+")  account number:"+sepordeAccounts.get(j).getAccountNumber()+"  mojodi:"+sepordeAccounts.get(j).getMojodi()+"  create time:"+sepordeAccounts.get(j).getCreateTime()+"  benefit percent:"+sepordeAccounts.get(j).getBenefitPercent()+"  account type:"+sepordeAccounts.get(j).getType());
            }
            for (int j=0;j<properties.size();j++)
            {
                if (properties.get(j).getOwnerNationalCode()==people.get(i).getNationalCode()) System.out.println("property("+(j+1)+")  address:"+properties.get(j).getPropertyAddress()+"  property value:"+properties.get(j).getValue()+"  document code:"+properties.get(j).getDocumentCode());
            }
            System.out.println("🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨");
        }
        for (int i=0;i<people.size();i++)
        {
            for (int j=0;j<jariBankAccounts.size();j++)
            {
                if (jariBankAccounts.get(j).getOwnerNationalCode() == people.get(i).getNationalCode()) {
                    people.get(i).setMoneyBag(people.get(i).getMoneyBag() + jariBankAccounts.get(j).getMojodi());
                    jariBankAccounts.get(j).setMojodi(0);
                }
            }
            for (int j=0;j<qarzolhassaneAccounts.size();j++)
            {
                if (qarzolhassaneAccounts.get(j).getOwnerNationalCode() == people.get(i).getNationalCode())
                {
                    people.get(i).setMoneyBag(people.get(i).getMoneyBag() + qarzolhassaneAccounts.get(j).getMojodi());
                    qarzolhassaneAccounts.get(j).setMojodi(0);
                }
            }
            for (int j=0;j<sepordeAccounts.size();j++)
            {
                if (sepordeAccounts.get(j).getOwnerNationalCode()==people.get(i).getNationalCode())
                {
                    people.get(i).setMoneyBag(people.get(i).getMoneyBag()+sepordeAccounts.get(j).getMojodi());
                    sepordeAccounts.get(j).setMojodi(0);
                }
            }
        }
        for (int i=0;i<people.size();i++)
        {
            System.out.println("("+(i+1)+")  name:"+people.get(i).getName()+"  age:"+people.get(i).getAge()+"  gender:"+people.get(i).getGender()+"  national code:"+people.get(i).getNationalCode()+"  money bag:"+people.get(i).getMoneyBag());
            for (int j=0;j<jariBankAccounts.size();j++)
            {
                if (jariBankAccounts.get(j).getOwnerNationalCode()==people.get(i).getNationalCode())  System.out.println("jari account("+(j+1)+")  account number:"+jariBankAccounts.get(j).getAccountNumber()+"  mojodi:"+jariBankAccounts.get(j).getMojodi()+"  create time:"+jariBankAccounts.get(j).getCreateTime());
            }
            for (int j=0;j<qarzolhassaneAccounts.size();j++)
            {
                if (qarzolhassaneAccounts.get(j).getOwnerNationalCode()==people.get(i).getNationalCode())  System.out.println("qarzolhassane account("+(j+1)+")  account number:"+qarzolhassaneAccounts.get(j).getAccountNumber()+"  mojodi:"+qarzolhassaneAccounts.get(j).getMojodi()+"  create time:"+qarzolhassaneAccounts.get(j).getCreateTime());
            }
            for (int j=0;j<sepordeAccounts.size();j++)
            {
                if (sepordeAccounts.get(j).getOwnerNationalCode()==people.get(i).getNationalCode())  System.out.println("sepored account("+(j+1)+")  account number:"+sepordeAccounts.get(j).getAccountNumber()+"  mojodi:"+sepordeAccounts.get(j).getMojodi()+"  create time:"+sepordeAccounts.get(j).getCreateTime()+"  benefit percent:"+sepordeAccounts.get(j).getBenefitPercent()+"  account type:"+sepordeAccounts.get(j).getType());
            }
            for (int j=0;j<properties.size();j++)
            {
                if (properties.get(j).getOwnerNationalCode()==people.get(i).getNationalCode()) System.out.println("property("+(j+1)+")  address:"+properties.get(j).getPropertyAddress()+"  property value:"+properties.get(j).getValue()+"  document code:"+properties.get(j).getDocumentCode());
            }
            System.out.println("🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦");
        }
    }
    static String time()
    {
        if (today==0)
        {
            today++;
            return "today is day 1 of week "+week+" of month "+month;
        }
        else if (today==1)
        {
            today++;
            return "today is day 2 of week "+week+" of month "+month;
        }
        else if (today==2)
        {
            today++;
            return "today is day 3 of week "+week+" of month "+month;
        }
        else if (today==3)
        {
            today++;
            return "today is day 4 of week "+week+" of month "+month;
        }
        else if (today==4)
        {
            today++;
            return "today is day 5 of week "+week+" of month "+month;
        }
        else if (today==5)
        {
            today++;
            return "today is day 6 of week "+week+" of month "+month;
        }
        else
        {
            if (week==4)
            {
                week=1;
                month++;
            }
            today=0;
            week++;
            return "today is Saturday of week "+week+" of month "+month;
        }
    }
    static String payVam(int vamValue,int accNumber,String acType) throws IOException
    {
        ArrayList<JariBankAccount> jariBankAccounts=new ArrayList<>();
        ArrayList<QarzolhassaneAccount> qarzolhassaneAccounts=new ArrayList<>();
        ArrayList<SepordeAccount> sepordeAccounts=new ArrayList<>();
        int mojodi=10,check=-1,accNum;
        String accType="";
        if (acType.equals("shortTime") || acType.equals("longTime")|| accType.equals("special"))
        {
            accType=acType;
            acType="seporde";
        }
        File file=new File(acType);
        File file1=new File(acType+"AccNumber");
        FileOutputStream fos=new FileOutputStream(file,true);
        Formatter formatter=new Formatter(fos);
        Scanner scanner=new Scanner(file);
        Scanner scanner1=new Scanner(file1);
        accNum=scanner1.nextInt();
        if (acType.equals("jari") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                JariBankAccount jba=new JariBankAccount(0,0,0,0,0);
                jariBankAccounts.add(jba);
                jariBankAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                jariBankAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (jariBankAccounts.get(i).getAccountNumber()==accNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else jariBankAccounts.get(i).setMojodi(scanner.nextInt());
                jariBankAccounts.get(i).setCreateTime(scanner.nextInt());
                jariBankAccounts.get(i).setNegativeScore(scanner.nextInt());
            }
            mojodi+=vamValue;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {
                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", jariBankAccounts.get(i).getOwnerNationalCode(), jariBankAccounts.get(i).getAccountNumber(), jariBankAccounts.get(i).getMojodi(),
                            jariBankAccounts.get(i).getCreateTime(), jariBankAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", jariBankAccounts.get(i).getOwnerNationalCode(), jariBankAccounts.get(i).getAccountNumber(),
                            mojodi, jariBankAccounts.get(i).getCreateTime(), jariBankAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
            }
        }
        if (acType.equals("qarzolhassane") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                QarzolhassaneAccount qba=new QarzolhassaneAccount(0,0,0,0,0);
                qarzolhassaneAccounts.add(qba);
                qarzolhassaneAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                qarzolhassaneAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (qarzolhassaneAccounts.get(i).getAccountNumber()==accNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else qarzolhassaneAccounts.get(i).setMojodi(scanner.nextInt());
                qarzolhassaneAccounts.get(i).setCreateTime(scanner.nextInt());
                qarzolhassaneAccounts.get(i).setNegativeScore(scanner.nextInt());
            }
            mojodi+=vamValue;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {
                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", qarzolhassaneAccounts.get(i).getOwnerNationalCode(), qarzolhassaneAccounts.get(i).getAccountNumber(), qarzolhassaneAccounts.get(i).getMojodi(),
                            qarzolhassaneAccounts.get(i).getCreateTime(), qarzolhassaneAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t", qarzolhassaneAccounts.get(i).getOwnerNationalCode(), qarzolhassaneAccounts.get(i).getAccountNumber(),mojodi,
                            qarzolhassaneAccounts.get(i).getCreateTime(), qarzolhassaneAccounts.get(i).isNegativeScore());
                    formatter.close();
                }
            }
        }
        if (accType.equals("shortTime") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
                sepordeAccounts.add(sba);
                sepordeAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                sepordeAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (sepordeAccounts.get(i).getAccountNumber()==accNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else sepordeAccounts.get(i).setMojodi(scanner.nextInt());
                sepordeAccounts.get(i).setCreateTime(scanner.nextInt());
                sepordeAccounts.get(i).setNegativeScore(scanner.nextInt());
                sepordeAccounts.get(i).setBenefitPercent(scanner.nextInt());
                sepordeAccounts.get(i).setPeriod(scanner.nextInt());
                sepordeAccounts.get(i).setType(scanner.next());
            }
            if (today+(week*7)+(month*30)>=sepordeAccounts.get(check).getCreateTime()+sepordeAccounts.get(check).getPeriod())
            {
                mojodi=mojodi+(mojodi*sepordeAccounts.get(check).getBenefitPercent()/100);
            }
            mojodi+=vamValue;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {
                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t", sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), sepordeAccounts.get(i).getMojodi(), sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t",sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), mojodi, sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
            }
        }
        if (accType.equals("longTime") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
                sepordeAccounts.add(sba);
                sepordeAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                sepordeAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (sepordeAccounts.get(i).getAccountNumber()==accNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else sepordeAccounts.get(i).setMojodi(scanner.nextInt());
                sepordeAccounts.get(i).setCreateTime(scanner.nextInt());
                sepordeAccounts.get(i).setNegativeScore(scanner.nextInt());
                sepordeAccounts.get(i).setBenefitPercent(scanner.nextInt());
                sepordeAccounts.get(i).setPeriod(scanner.nextInt());
                sepordeAccounts.get(i).setType(scanner.next());
            }
            if (today+(week*7)+(month*30)>=sepordeAccounts.get(check).getCreateTime()+sepordeAccounts.get(check).getPeriod())
            {
                mojodi=mojodi+(mojodi*sepordeAccounts.get(check).getBenefitPercent())/100;
            }
            mojodi+=vamValue;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {

                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t", sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), sepordeAccounts.get(i).getMojodi(), sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t",sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), mojodi, sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
            }
        }
        if (accType.equals("special") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                SepordeAccount sba=new SepordeAccount(0,0,0,0,0,0,0,"");
                sepordeAccounts.add(sba);
                sepordeAccounts.get(i).setOwnerNationalCode(scanner.nextInt());
                sepordeAccounts.get(i).setAccountNumber(scanner.nextInt());
                if (sepordeAccounts.get(i).getAccountNumber()==accNumber)
                {
                    mojodi=scanner.nextInt();
                    check=i;
                }
                else sepordeAccounts.get(i).setMojodi(scanner.nextInt());
                sepordeAccounts.get(i).setCreateTime(scanner.nextInt());
                sepordeAccounts.get(i).setNegativeScore(scanner.nextInt());
                sepordeAccounts.get(i).setBenefitPercent(scanner.nextInt());
                sepordeAccounts.get(i).setPeriod(scanner.nextInt());
                sepordeAccounts.get(i).setType(scanner.next());
            }
            if (today+(week*7)+(month*30)>=sepordeAccounts.get(check).getCreateTime()+sepordeAccounts.get(check).getPeriod())
            {
                mojodi=mojodi+(mojodi*sepordeAccounts.get(check).getBenefitPercent()/100);
            }
            mojodi+=vamValue;
            Formatter formatter1=new Formatter(file);
            for (int i=0;i<accNum;i++)
            {

                if (check!=i)
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t", sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), sepordeAccounts.get(i).getMojodi(), sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
                else
                {
                    formatter.format("%d\t%d\t%d\t%s\t%d\t%d\t%d\t%s\t",sepordeAccounts.get(i).getOwnerNationalCode(), sepordeAccounts.get(i).getAccountNumber(), mojodi, sepordeAccounts.get(i).getCreateTime(),
                            sepordeAccounts.get(i).isNegativeScore(),sepordeAccounts.get(i).getBenefitPercent(),sepordeAccounts.get(i).getPeriod(),sepordeAccounts.get(i).getType());
                    formatter.flush();
                }
            }
        }
        return "vam paid";
    }
}
class Person
{
    private int nationalCode,age,moneyBag;
    private String name,gender;

    public Person(int nationalCode, int age, int moneyBag, String name, String gender) {
        this.nationalCode = nationalCode;
        this.age = age;
        this.moneyBag = moneyBag;
        this.name = name;
        this.gender = gender;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoneyBag() {
        return moneyBag;
    }

    public void setMoneyBag(int moneyBag) {
        this.moneyBag = moneyBag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
class Property
{
    private int ownerNationalCode,value,documentCode;
    private String buyTime,propertyAddress;

    public Property(int ownerNationalCode, int value, int documentCode, String buyTime, String propertyAddress) {
        this.ownerNationalCode = ownerNationalCode;
        this.value = value;
        this.documentCode = documentCode;
        this.buyTime = buyTime;
        this.propertyAddress = propertyAddress;
    }

    public int getOwnerNationalCode() {
        return ownerNationalCode;
    }

    public void setOwnerNationalCode(int ownerNationalCode) {
        this.ownerNationalCode = ownerNationalCode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(int documentCode) {
        this.documentCode = documentCode;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }
}
abstract class BankAccount
{
    private int ownerNationalCode,accountNumber,mojodi,negativeScore;
    private int createTime;

    public BankAccount(int ownerNationalCode, int accountNumber, int mojodi, int createTime, int negativeScore) {
        this.ownerNationalCode = ownerNationalCode;
        this.accountNumber = accountNumber;
        this.mojodi = mojodi;
        this.createTime = createTime;
        this.negativeScore = negativeScore;
    }

    public int getOwnerNationalCode() {
        return ownerNationalCode;
    }

    public void setOwnerNationalCode(int ownerNationalCode) {
        this.ownerNationalCode = ownerNationalCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getMojodi() {
        return mojodi;
    }

    public void setMojodi(int mojodi) {
        this.mojodi = mojodi;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int isNegativeScore() {
        return negativeScore;
    }

    public void setNegativeScore(int negativeScore) {
        this.negativeScore = negativeScore;
    }
}
class BankCart
{
    private int cartNumber,accountNumber;

    public BankCart(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    String createBankCart(int accNumber,String accType) throws IOException
    {
        int check=-1,accNum;
        File file=new File(accType);
        File file1=new File(accType+"AccNumber");
        Scanner scanner=new Scanner(file);
        Scanner scanner1=new Scanner(file1);
        accNum=scanner1.nextInt();
        if (accType.equals("jari") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                scanner.nextInt();
                if (scanner.nextInt()==accNumber) check=i;
                scanner.nextInt();
                scanner.next();
                scanner.nextInt();
            }
        }
        if (accType.equals("qarzolhassane") && file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                scanner.nextInt();
                if (scanner.nextInt()==accNumber) check=i;
                scanner.nextInt();
                scanner.next();
                scanner.nextInt();
            }
        }
        if (check==-1) return "this account is not exist";
        else
        {
            Random random=new Random();
            setCartNumber(random.nextInt(100000));
            return "cart added";
        }
    }
}
class DasteChek
{
    private int accountNumber,price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DasteChek(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    String createDasteChek(int accNumber) throws IOException
    {
        int check=-1,accNum;
        File file=new File("jari");
        File file1=new File("jariAccNumber");
        Scanner scanner=new Scanner(file);
        Scanner scanner1=new Scanner(file1);
        accNum=scanner1.nextInt();
        if (file.exists())
        {
            for (int i=0;i<accNum;i++)
            {
                scanner.nextInt();
                if (scanner.nextInt()==accNumber) check=i;
                scanner.nextInt();
                scanner.next();
                scanner.nextInt();
            }
        }
        if (check==-1) return "this account is not exist";
        else return "daste chek added";
    }
}
class JariBankAccount extends BankAccount
{
    static ArrayList<BankCart> bankCarts=new ArrayList<>();
    static ArrayList<DasteChek> dasteCheks=new ArrayList<>();
    protected BankCart bankCart;
    protected DasteChek dasteChek;

    public JariBankAccount(int ownerNationalCode, int accountNumber, int mojodi, int createTime,
                           int negativeScore) {
        super(ownerNationalCode, accountNumber, mojodi, createTime, negativeScore);
    }
}
class QarzolhassaneAccount extends BankAccount
{
    static ArrayList<BankCart> bankCarts=new ArrayList<>();
    protected BankCart bankCart;

    public QarzolhassaneAccount(int ownerNationalCode, int accountNumber, int mojodi, int createTime,
                                int negativeScore) {
        super(ownerNationalCode, accountNumber, mojodi, createTime, negativeScore);
    }
}
class SepordeAccount extends BankAccount
{
    private int benefitPercent,period;
    private String type;

    public SepordeAccount(int ownerNationalCode, int accountNumber, int mojodi, int createTime,
                          int negativeScore, int benefitPercent, int period, String type) {
        super(ownerNationalCode, accountNumber, mojodi, createTime, negativeScore);
        this.benefitPercent = benefitPercent;
        this.period = period;
        this.type = type;
    }

    public int getBenefitPercent() {
        return benefitPercent;
    }

    public void setBenefitPercent(int benefitPercent) {
        this.benefitPercent = benefitPercent;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
class InvalidType extends Exception
{
    String message ="🟥🟥invalid account type🟥🟥";
}