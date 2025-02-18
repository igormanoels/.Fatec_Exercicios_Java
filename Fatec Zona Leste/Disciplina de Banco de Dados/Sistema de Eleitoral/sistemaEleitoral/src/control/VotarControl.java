package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import control.bd.SqlServer;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Voto;
import view.VotarView;

public class VotarControl {

    private VotarView telaVoto;
    private List<String> votaram;
    private Alert alerta = new Alert(AlertType.CONFIRMATION);
    private SqlServer sql = new SqlServer();
    private String mensagem = null;

    public VotarControl(VotarView v) {
        this.votaram  = new ArrayList<>();
        this.telaVoto = v;
    }

    public void RegistrarVoto() {
        if(!(telaVoto.txtCPF.getText().isEmpty() && telaVoto.txtNumero.getText().isEmpty())) {
            if (!(this.votaram.contains(this.telaVoto.txtCPF.getText()))) {
                Voto voto = new Voto(telaVoto.txtCPF.getText(), telaVoto.txtNumero.getText());
                //this.votaram.add(telaVoto.txtCPF.getText());
                this.votaram.add(voto.getEleitor().getCpf());

                try {
                    if (!(telaVoto.txtCPF.getText().isEmpty() || telaVoto.txtNumero.getText().isEmpty())) {
                        Connection conexao = DriverManager.getConnection(sql.getURL(), sql.getUSER(), sql.getPASS());
                        PreparedStatement stm = conexao.prepareStatement("""
                            INSERT INTO Eleitor (cpf) VALUES (?);
                            INSERT INTO Voto (eleitorCpf, candidatoNumero) VALUES (?, ?);
                        """);
                        stm.setString(1, voto.getEleitor().getCpf());
                        stm.setString(2, voto.getEleitor().getCpf());
                        stm.setInt(3, voto.getNumero());
                        int linhasAfetadas = stm.executeUpdate();
                        this.mensagem = (linhasAfetadas > 0) ? "Seu voto foi confirmado com sucesso!" : "Seu voto não foi confirmado, tente novamente!";
                        alerta.setAlertType(AlertType.CONFIRMATION);
                    } else {
                        this.mensagem = "Seu voto não foi confirmado, tente novamente!";
                        alerta.setAlertType(AlertType.INFORMATION);
                    }
                } catch (SQLException e) {
                    this.mensagem = "Erro na conexão: " + e.getMessage();
                    alerta.setAlertType(AlertType.ERROR);

                }
            }
        } else{
            this.mensagem = "Preencha ambos os campos!";
            alerta.setAlertType(AlertType.ERROR);
        }      

            alerta.setAlertType(AlertType.INFORMATION);
            alerta.setTitle("Atenção!");
            alerta.setHeaderText(null);
            alerta.setContentText(this.mensagem);
            alerta.showAndWait();
       
        telaVoto.limparTela();
    }


    public void encerrarVotacao (Stage stage, view.Menu menu) {
        TextInputDialog logar = new TextInputDialog();
        logar.setTitle("Encerrar votação");
        logar.setHeaderText("Entre com a senha para finalizar a votação: ");
        logar.setContentText("Senha:");
        
        logar.showAndWait().ifPresent(senha -> {
            if (senha.equals("123456")) {
                alerta.setAlertType(AlertType.INFORMATION);
                alerta.setTitle("Sucesso");
                alerta.setHeaderText(null);
                alerta.setContentText("Votação encerrada com sucesso!");
                alerta.showAndWait();
                stage.setScene(menu.telaPrincipal(stage));
            } else {
                alerta.setAlertType(AlertType.ERROR);
                alerta.setTitle("Erro");
                alerta.setHeaderText(null);
                alerta.setContentText("Senha incorreta. Tente novamente.");
                alerta.showAndWait();
            }
        });

    }
    
}
