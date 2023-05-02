package br.com.funcionario.domain;

import br.com.funcionario.domain.enuns.EstadoCivil;
import br.com.funcionario.domain.enuns.FuncaoFuncionarioEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionarios_cnpj")
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioCnpj extends Funcionario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "funcao_funcionario", length = 25)
    @Enumerated(EnumType.STRING)
    private FuncaoFuncionarioEnum funcaoFuncionarioEnum;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    @Column(name = "salario")
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "funcionario_cnpj")
    private Salario salario;
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private Date dataAdmissao;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "funcionario_clt")
    private List<Depedente> depedentesList = new ArrayList<>();
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "funcionario_cnpj")
    private Endereco endereco;
    @OneToOne()
    private Funcionario funcionario;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public LocalTime getHoraInicial() {
        return horaInicial;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
