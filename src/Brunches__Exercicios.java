import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Brunches__Exercicios {
    private static final double PRECO_CRIANCA = 75.0;
    private static final double PRECO_ADOLESCENTE = 100.0;
    private static final double PRECO_ADULTO = 150.0;
    private static final double PRECO_IDOSO = 75.0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculadora de Hospedagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Idade:");
        JTextField idadeField = new JTextField(10);
        JButton calcularButton = new JButton("Calcular");
        JTextArea resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idade = Integer.parseInt(idadeField.getText());

                    String categoria;
                    double valorHospedagem;

                    if (idade < 0) {
                        resultadoArea.setText("A idade não pode ser negativa.");
                        return;
                    } else if (idade < 13) {
                        categoria = "Criança";
                        valorHospedagem = PRECO_CRIANCA;
                    } else if (idade < 18) {
                        categoria = "Adolescente";
                        valorHospedagem = PRECO_ADOLESCENTE;
                    } else if (idade < 60) {
                        categoria = "Adulto";
                        valorHospedagem = PRECO_ADULTO;
                    } else {
                        categoria = "Idoso";
                        valorHospedagem = PRECO_IDOSO;
                    }

                    resultadoArea.setText("Categoria: " + categoria + "\nValor da Hospedagem: " + valorHospedagem + " R$");
                } catch (NumberFormatException ex) {
                    resultadoArea.setText("Por favor, insira uma idade válida.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Usando GridBagLayout para centralizar o painel

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10); // Margem

        panel.add(label, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.weightx = 1.0; // Expandir horizontalmente
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        panel.add(idadeField, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.weightx = 0.0; // Restaurar o valor padrão
        gridBagConstraints.fill = GridBagConstraints.NONE;

        panel.add(calcularButton, gridBagConstraints);

        frame.add(panel, BorderLayout.CENTER); // Adicionando o painel centralizado na janela
        frame.add(resultadoArea, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Centralizando a janela na tela
    }
}