import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Ogrenci {
    private String ad;
    private String soyad;
    private String bolum;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    @Override
    public String toString() {
        return "Ad: " + ad +
                "\nSoyad: " + soyad +
                "\nBölüm: " + bolum + "\n";
    }
}

class Ders {
    private String dersKodu;
    private String dersAd;
    private String dersDonem;

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }

    public String getDersDonem() {
        return dersDonem;
    }

    public void setDersDonem(String dersDonem) {
        this.dersDonem = dersDonem;
    }

    @Override
    public String toString() {
        return "Ders Kodu: " + dersKodu +
                "\nDers Adı: " + dersAd +
                "\nDönemi: " + dersDonem + "\n";
    }
}

public class AnaForm extends JFrame {
    private JButton öğrenciKayıtButton;
    private JPanel JPanel;
    private JLabel LabelIsim;
    private JButton DersButton;
    private JButton EkleButton;
    private ArrayList<Ogrenci> ogrenciList = new ArrayList<>();
    private ArrayList<Ders> dersList = new ArrayList<>();
    private JFrame ogrenciKayitFrame;

    public AnaForm() {
        setTitle("Ana Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new java.awt.FlowLayout());

        EkleButton = new JButton("Ekle");
        add(EkleButton);

        öğrenciKayıtButton = new JButton("Öğrenci Kayıt");
        add(öğrenciKayıtButton);

        DersButton = new JButton("Ders Kayıt");
        add(DersButton);

        öğrenciKayıtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogrenciKayitFrame = new JFrame("Öğrenci Bilgi Girişi");

                JLabel adLabel = new JLabel("Ad:");
                JTextField adField = new JTextField(15);
                JLabel soyadLabel = new JLabel("Soyad:");
                JTextField soyadField = new JTextField(15);
                JLabel bolumLabel = new JLabel("Bölüm:");
                JTextField bolumField = new JTextField(15);

                // Dersleri içeren JComboBox oluşturuluyor
                JComboBox<String> derslerComboBox = new JComboBox<>();
                for (Ders ders : dersList) {
                    derslerComboBox.addItem(ders.getDersAd()); // Sadece ders adı ekleniyor
                }

                JButton kaydetButton = new JButton("Kaydet");

                ogrenciKayitFrame.setLayout(new java.awt.FlowLayout());
                ogrenciKayitFrame.add(adLabel);
                ogrenciKayitFrame.add(adField);
                ogrenciKayitFrame.add(soyadLabel);
                ogrenciKayitFrame.add(soyadField);
                ogrenciKayitFrame.add(bolumLabel);
                ogrenciKayitFrame.add(bolumField);
                ogrenciKayitFrame.add(derslerComboBox); // Dersleri içeren JComboBox
                ogrenciKayitFrame.add(kaydetButton);

                kaydetButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ad = adField.getText();
                        String soyad = soyadField.getText();
                        String bolum = bolumField.getText();

                        String secilenDers = (String) derslerComboBox.getSelectedItem(); // Seçilen dersi al

                        Ogrenci yeniOgrenci = new Ogrenci();
                        yeniOgrenci.setAd(ad);
                        yeniOgrenci.setSoyad(soyad);
                        yeniOgrenci.setBolum(bolum);

                        // Seçilen dersin bilgilerini al ve ekrana yazdır
                        for (Ders ders : dersList) {
                            if (ders.getDersAd().equals(secilenDers)) {
                                JOptionPane.showMessageDialog(null, "Öğrenci bilgileri:\n" + yeniOgrenci.toString() +
                                        "\nSeçilen Ders Bilgileri:\n" + ders.toString());
                                break;
                            }
                        }

                        ogrenciList.add(yeniOgrenci);

                        JOptionPane.showMessageDialog(null, "Öğrenci bilgileri kaydedildi.");

                        ogrenciKayitFrame.dispose();
                        setVisible(true);
                    }
                });

                ogrenciKayitFrame.setSize(300, 250);
                ogrenciKayitFrame.setLocationRelativeTo(null);
                ogrenciKayitFrame.setVisible(true);

                setVisible(false);
            }
        });

        DersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogrenciKayitFrame = new JFrame("Ders Bilgi Girişi");

                JLabel dersKoduLabel = new JLabel("Ders Kodu:");
                JTextField dersKoduField = new JTextField(15);
                JLabel dersAdLabel = new JLabel("Ders Adı:");
                JTextField dersAdField = new JTextField(15);
                JLabel dersDonemLabel = new JLabel("Ders Dönemi:");
                JTextField dersDonemField = new JTextField(15);

                JButton kaydetButton = new JButton("Kaydet");

                ogrenciKayitFrame.setLayout(new java.awt.FlowLayout());
                ogrenciKayitFrame.add(dersKoduLabel);
                ogrenciKayitFrame.add(dersKoduField);
                ogrenciKayitFrame.add(dersAdLabel);
                ogrenciKayitFrame.add(dersAdField);
                ogrenciKayitFrame.add(dersDonemLabel);
                ogrenciKayitFrame.add(dersDonemField);
                ogrenciKayitFrame.add(kaydetButton);

                kaydetButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String dersKodu = dersKoduField.getText();
                        String dersAd = dersAdField.getText();
                        String dersDonem = dersDonemField.getText();

                        Ders yeniDers = new Ders();
                        yeniDers.setDersKodu(dersKodu);
                        yeniDers.setDersAd(dersAd);
                        yeniDers.setDersDonem(dersDonem);
                        dersList.add(yeniDers);

                        JOptionPane.showMessageDialog(null, "Ders bilgileri kaydedildi.");

                        ogrenciKayitFrame.dispose();
                        setVisible(true);
                    }
                });

                ogrenciKayitFrame.setSize(300, 250);
                ogrenciKayitFrame.setLocationRelativeTo(null);
                ogrenciKayitFrame.setVisible(true);

                setVisible(false);
            }
        });

        EkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dersList.isEmpty() && ogrenciList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen en az bir ders veya öğrenci ekleyin.");
                } else {
                    StringBuilder message = new StringBuilder();
                    if (!dersList.isEmpty()) {
                        message.append("Dersler:\n").append(dersList.toString()).append("\n");
                    }
                    if (!ogrenciList.isEmpty()) {
                        message.append("Öğrenciler:\n");
                        for (Ogrenci ogrenci : ogrenciList) {
                            message.append(ogrenci.toString()).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, message.toString());
                }
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AnaForm().setVisible(true);
        });
    }
}
