import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainUI {
    private JButton Button3;
    private JButton Button2;
    private JButton Button1;
    private JButton Button0;
    private JTextField textField_name;
    private JTextField textField_src;
    private JTextField textField_des;
    private JTextField textField_num;
    private JTextArea textArea1;
    private JButton Button_start;
    private JTextField textField_testname;
    public JPanel Panel1;

    private String[][] info;
    private int StuNum = 0;
    BufferedReader bufferedReader1,bufferedReader2;

    public MainUI() {
        Button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField_name.setText(FileChoose());
            }
        });
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField_num.setText(FileChoose());
            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField_src.setText(DirChoose());
            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField_des.setText(DirChoose());
            }
        });
        Button_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainUI main = new MainUI();
                try {
                    main.setInfo();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                main.reName();
            }
        });
    }

    public String FileChoose(){
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.showDialog(new JLabel(), "选择");
        File file=jfc.getSelectedFile();
        if(file.isDirectory()){
            JOptionPane.showMessageDialog(null, "不能选择目录，请选择文件。", "提示",JOptionPane.WARNING_MESSAGE);
        }

        return jfc.getSelectedFile().getName();
    }

    public String DirChoose(){
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.showDialog(new JLabel(), "选择");
        File file=jfc.getSelectedFile();
        if(file.isFile()){
            JOptionPane.showMessageDialog(null, "不能选择文件，请选择目录。", "提示",JOptionPane.WARNING_MESSAGE);
        }

        return jfc.getSelectedFile().getName();
    }

    public void setInfo()throws java.io.IOException{
        info = new String[100][2];
        FileInputStream file1 = new FileInputStream(textField_name.getText());
        FileInputStream file2 = new FileInputStream(textField_num.getText());

        bufferedReader1 = new BufferedReader(new InputStreamReader(file1));
        String str;
        for(int i = 0;(str = bufferedReader1.readLine()) != null;i++){
            info[i][0] = str;
            System.out.println(info[i][0]);
            StuNum = i;
        }

        bufferedReader2 = new BufferedReader(new InputStreamReader(file2));
        String str2;
        int count = 0;
        for(int i = 0;(str2 = bufferedReader2.readLine()) != null;i++){
            info[i][1] = str2;
            System.out.println(info[i][1]);
            count = i;
        }
        if(count != StuNum){
            JOptionPane.showMessageDialog(null, "姓名数量与学号数量不匹配！", "提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void reName(){
        File oldFile = new File(textField_src.getText());
        File[] fs = oldFile.listFiles();
        for(int i = 0 ;i<StuNum;i++){
            String name = fs[i].getName();
            textArea1.append("读入文件" + name);
            int flag = 0;

            for(int j = 0 ; j < 44 ; j++){
                if(name.contains(info[j][0])){
                    String newname = "计算181_" + info[j][1]+"_"+info[j][0]+"_"+textField_testname;
                    File dest = new File(textField_des.getText() +"/" + newname+".doc");
                    fs[i].renameTo(dest);
                    break;
                }
                flag++;
            }
            if(flag == StuNum){
                System.out.println(name + "     没有在数据库找到姓名匹配");
            }
        }
    }

}
