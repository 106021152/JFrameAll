import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EncryptFile extends JFrame {
    private JLabel jlbEn = new JLabel("加密法");
    private JLabel jlbKey = new JLabel("Key");
    private JLabel jlbO = new JLabel("原始檔");
    private JLabel jlbE = new JLabel("加密檔");
    private JButton jbtnRun = new JButton("Run");
    private JButton jbtnClose = new JButton("Close");
    private JButton jbtnChoose1 = new JButton("Choose");
    private JButton jbtnChoose2 = new JButton("Choose");
    private JTextField jtfKey = new JTextField("");
    private JTextField jtfO = new JTextField();
    private JTextField jtfE = new JTextField();
    private String [] methodstr = {"DES","AES","XOR","Caesar"};
    private JComboBox jcb = new JComboBox(methodstr);
    private JProgressBar jpb = new JProgressBar();
    private JPanel jpnC = new JPanel(new GridLayout(2,1,1,1));
    private JPanel jpnN = new JPanel(new GridLayout(1,6,1,1));
    private JPanel jpnW = new JPanel(new GridLayout(2,1,1,1));
    private JPanel jpnE = new JPanel(new GridLayout(2,1,1,1));
    private JPanel jpnS = new JPanel(new GridLayout(1,1,1,1));
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screew = screenSize.width,screeh = screenSize.height;
    private int frmw = 450,frmh = 200;
    private Container cp;
    int val;
    Timer tim;
    public EncryptFile(){
        init();
    }
    public void init(){

        this.setBounds(screew/2 - frmw/2 , screeh/2 - frmh/2 , frmw,frmh);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpnN,BorderLayout.NORTH);
        cp.add(jpnW,BorderLayout.WEST);
        cp.add(jpnE,BorderLayout.EAST);
        cp.add(jpnS,BorderLayout.SOUTH);
        jpnN.add(jlbEn);
        jpnN.add(jcb);
        jpnN.add(jlbKey);
        jpnN.add(jtfKey);
        jpnN.add(jbtnRun);
        jpnN.add(jbtnClose);
        jpnW.add(jlbO);
        jpnC.add(jtfO);
        jpnE.add(jbtnChoose1);
        jpnW.add(jlbE);
        jpnC.add(jtfE);
        jpnE.add(jbtnChoose2);
        jpnS.add(jpb);
        tim = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(val< 100){
                    jpb.setMaximum(100);
                }
            }
        });
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Success sc = new Success();
                sc.setVisible(true);
            }
        });
    }
}