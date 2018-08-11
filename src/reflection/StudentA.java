package reflection;

/**
 * Created by Administrator on 2018/8/11.
 */
public class StudentA {

}

class StudentB {

    //无参构造函数
    public StudentB() {
        System.out.println("call Student()~~~");
    }

    //一个int类型参数 构造函数
    public StudentB(int i) {
        System.out.println("call Student(int i)~~~ i:" + String.valueOf(i));
    }

    //一个int类型参数一个String类型 构造函数
    public StudentB(int i, String s) {
        System.out.println("call StudentB(int i, String s) ~~~i: " + String.valueOf(i) + ", s:" + s);
    }

    //2个String类型 私有 构造函数
    private StudentB(String s1, String s2) {
        System.out.println("private!! call Student(int i)~~~");
    }
}

class StudentC {

    public int number1;
    public String str1;
    private int flag;

    public StudentC(int i, String str, int flag) {
        number1 = i;
        str1 = str;
        this.flag = flag;
    }

    public StudentC() {

    }

    public void print() {
        System.out.println("number1 is:" + number1 + " str1 is:" + str1 + " flag is:" + flag);
    }

    public void yee() {
        System.out.println("nothing~~~");
    }
}

class StudentD {

  public StudentD() {}

  public void show1() {
      System.out.println("public void show1() ~~~");
  }

  public void show2(int age) {
      System.out.println("void show2(int age) ~~~ age is:" + age);
  }

  protected void show3(String name) {

      System.out.println("protected void show3(String name) ~~~ name is:" + name);
  }

  public void show4(int age, String name) {

      System.out.println("private void show4(int age, String name) ~~~ age is:" + age + " name is:" + name);
  }
}