import java.io.*;

public class Rename {
    private String[][] info;
    private FileInputStream file1,file2;
    BufferedReader bufferedReader1,bufferedReader2;

/*    public void setInfo()throws java.io.IOException{
        info = new String[44][2];
        file1 = new FileInputStream("D://kkans//Desktop//1.txt");
        file2 = new FileInputStream("D://kkans//Desktop//2.txt");

        bufferedReader1 = new BufferedReader(new InputStreamReader(file1));
        String str;
        for(int i = 0;(str = bufferedReader1.readLine()) != null;i++){
            info[i][0] = str;
            System.out.println(info[i][0]);
        }
        bufferedReader2 = new BufferedReader(new InputStreamReader(file2));
        String str2;
        for(int i = 0;(str2 = bufferedReader2.readLine()) != null;i++){
            info[i][1] = str2;
            System.out.println(info[i][1]);
        }
    }

    public void reName(){
        File oldFile = new File("D://kkans//Desktop//sw3");
        File[] fs = oldFile.listFiles();
        for(int i = 0 ;i<46;i++){
            String name = fs[i].getName();
            System.out.println(name);
            int flag = 0;

            for(int j = 0 ; j < 44 ; j++){
                if(name.contains(info[j][0])){
                    String newname = "计算181_" + info[j][1]+"_"+info[j][0]+"_"+"面向对象系统分析";
                    File dest = new File("D://kkans//Desktop//sw3_new"+"/" + newname+".doc");
                    fs[i].renameTo(dest);
                    break;
                }
                flag++;
            }
            if(flag == 44){
                System.out.println(name + "     没有在数据库找到姓名匹配");
            }
        }
    } */

    public void FindSB() {
        File oldFile = new File("D://kkans//Desktop//sw3_new");
        File[] fs = oldFile.listFiles();
        for (int i = 0; i < 41; i++) {
            String name = fs[i].getName();
            System.out.println(name);
            int flag = 0;

            for (int j = 0; j < 44; j++) {
                if (name.contains(info[j][0])) {
                    info[j][1] = "-1";
                }
            }
        }

        for(int i = 0 ; i<44 ; i++){
            if(info[i][1]!="-1"){
                System.out.println(info[i][0] + "没交报告");
            }
        }
    }
}
