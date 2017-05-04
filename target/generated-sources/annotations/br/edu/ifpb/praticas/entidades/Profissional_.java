package br.edu.ifpb.praticas.entidades;

import br.edu.ifpb.praticas.entidades.Orcamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T20:51:12")
@StaticMetamodel(Profissional.class)
public class Profissional_ { 

    public static volatile SingularAttribute<Profissional, String> telefone;
    public static volatile ListAttribute<Profissional, Orcamento> orcamentos;
    public static volatile SingularAttribute<Profissional, String> nome;
    public static volatile SingularAttribute<Profissional, Integer> id;

}