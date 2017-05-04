package br.edu.ifpb.praticas.entidades;

import br.edu.ifpb.praticas.entidades.Cliente;
import br.edu.ifpb.praticas.entidades.Orcamento;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T20:51:12")
@StaticMetamodel(Solicitacao.class)
public class Solicitacao_ { 

    public static volatile SingularAttribute<Solicitacao, Boolean> fechado;
    public static volatile SingularAttribute<Solicitacao, Cliente> cliente;
    public static volatile SingularAttribute<Solicitacao, LocalDate> data;
    public static volatile ListAttribute<Solicitacao, Orcamento> orcamentos;
    public static volatile SingularAttribute<Solicitacao, Integer> id;
    public static volatile SingularAttribute<Solicitacao, Integer> nota;

}