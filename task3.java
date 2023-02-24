// В калькулятор добавьте возможность отменить последнюю операцию.
import java.util.Scanner;
import java.util.logging.*;
import java.util.ArrayList;
public class task3 {

    static float Calc(float number1,float number2,String sign){
        float result=0;
        switch (sign){
            case "+":
                result=number1+number2;
                break;
            case "-":
                result=number1-number2;
                break;
            case "*":
                result=number1*number2;
                break; 
            case "/":
                result=number1/number2;
                break;
            default:
            System.out.println("Неправильно ввели знак действия!"); 
        }
        return result;
    }    
    
    static Float x;
    static Float y;
    static String znak;
    public static void main(String[] args) {
        ArrayList <Float> results = new ArrayList<Float>();
        Integer condition=1;
        Scanner sc=new Scanner(System.in);

        boolean flag=false;
      
        while(flag==false){
            System.out.printf("Введите первое  число x: ");
            flag= sc.hasNextFloat();
            if (flag==false) {
                System.out.println("Неправильно ввели число!");
            }else {
                x=sc.nextFloat();
            }                       
            sc.nextLine();                 
        }             
        results.add(x);
    
        while(condition==1){ 
                                   
            flag=false;
            while(flag==false){
                System.out.print("Введите действие,которое вы хотите сделать(+,-,*,/): ");
                znak = sc.next();
                if (znak.equals("+")|znak.equals("-")|znak.equals("*")|znak.equals("/")){
                    flag=true;
                }else{
                    System.out.println("Неправильно ввели знак!");
                }
            }    


            flag=false;
            while(flag==false){
                System.out.printf("Введите второе  число y: ");
                flag= sc.hasNextFloat();
                if (flag==false){
                    System.out.println("Неправильно ввели число!");
                } else{
                    y=sc.nextFloat();  
                }
                sc.nextLine();                 
            }                  
            
            float resCulc=Calc(x, y, znak);
            results.add(resCulc);
            String result=String.format("%.2f",resCulc);
            // System.out.println(x+znak+y+"="+result);
            try{
                Logger logger=Logger.getLogger(task3.class.getName());
                logger.setLevel(Level.INFO);
                FileHandler fh=new FileHandler("log.txt",true);
                logger.addHandler(fh);
                SimpleFormatter sFormat=new SimpleFormatter();               
                fh.setFormatter(sFormat);
                logger.info(x+znak+y+"="+result);
                int menu=2;

                while(menu==2){
                    System.out.println("Если хотите:1) продолжить счет- введите 1; 2)отменить последнее действие-2;3)выйти из программы -3");
                    menu = sc.nextInt();
                    sc.nextLine();
                    if (menu==1){
                        x=results.get(results.size()-1);
                    } else if(menu==2){
                        if(results.size()>1){ 
                            results.remove(results.size()-1);
                            logger.info("Отмена последнего действия!Произошел откат до результата:"+results.get(results.size()-1));
                        } else{
                            System.out.println("Закончились действия для отмены!Вы можете выбрать первый или третий варинт.");  
                        }
                    } else if(menu==3){
                        condition=2;
                    } else {
                        System.out.println("Неправильно ввели значение. Повторите выбор еще раз.");
                        menu=2;
                    }
                }


                fh.close();
            } catch(Exception e){
                    System.out.println("Что то не так");
            }
           
        }    
        sc.close();
    }
}
