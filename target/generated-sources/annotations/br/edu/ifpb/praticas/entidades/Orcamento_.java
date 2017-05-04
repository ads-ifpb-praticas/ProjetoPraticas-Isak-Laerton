package br.edu.ifpb.praticas.entidades;

import br.edu.ifpb.praticas.entidades.Profissional;
import br.edu.ifpb.praticas.entidades.Solicitacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T20:51:12")
@StaticMetamodel(Orcamento.class)
public class Orcamento_ { 

    public static volatile SingularAttribute<Orcamento, Solicitacao> solicitacao;
    public static volatile SingularAttribute<Orcamento, Boolean> aprovado;
    public static volatile SingularAttribute<Orcamento, Double> valor;
    public static volatile SingularAttribute<Orcamento, Integer> id;
    public static volatile SingularAttribute<Orcamento, Profissional> profisisional;
    public static volatile SingularAttribute<Orcamento, String> descricao;

}