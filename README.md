# ProjetoPraticas-Isak-Laerton


Projeto de práticas 

Requisitos:

- O cliente poderá buscar por profissionais cadastrados de acordo com sua especialidade.
- O cliente deve criar uma demanda de serviço, ele deve informar uma faixa de data e horário para que o profissional possa atendê-lo.
- O profissional pode ter acesso aos tipos de serviço solicitados pelos clientes, anexar uma proposta para o serviço solicitado.
- O cliente pode avaliar os orçamentos anexados pelos profissionais, ele pode a partir dai definir qual o melhor profissional para seu serviço.
- O cliente pode avaliar o serviço prestado pelo profissional oferecendo um feedBack deste serviço, essa avaliação poderá ser positiva ou negativa, podendo oferece um comentário.
- O cliente ao verificar o perfil do profissional poderá verificar as avaliações de outros clientes a esse profissional.
- Deve ser possível de verificar a quantidade de solicitações atendidas por um profissional e suas qualificações positivas e negativas.
- O profissional poderá verificar em sua agenda os serviço confirmados, ainda não executados em uma agenda. Nesta agenda deve ser possível verificar endereço, mapas, meios de contato com o cliente correspondente.

- O usuário do sistema pode ser : Profissional, Cliente, e podendo um deles ser administrador
- Ao ser cadastrado um novo usuário, este deve ficar pendente para que o administrador do sistema possa liberá-lo.

Validações: 

- Usuário não pode conter um nome inválido, em branco ou com caractres especiais. Com tamanho mínimo de 6 e máximo 70 caracteres.
- Usuário deve ter um CPF válido.
- Usuário deve contér um e-mail válido.
- Endereço não pode ter nome da rua, avenida, etc.. menor que 6 e maior que 70 caracteres, não podendo ser em branco.
- Endereço não pode conter um bairro em branco.
- Endereço deve ter um número positívo e maior que zero.
- Endereço não pode conter uma cidade em branco.
- Endereço deve conter uma cidade com no máximo 50 caracteres.
- Endereço deve conter uma sigla de estado, com no máximo 2 carcateres.
- Solicitação não pode ter um intervalo de data hora inválido, ou seja data hora inicial deve ser menor que data hora final.
- Orçamento não pode ter uma data hora fora do interválo da solicitação associada.
- Uma Solicitação só pode ficar disponível para inclusão de orçamento até a data limite informada e/ ou um orçamento for aprovado.
- Uma avaliação só poderá ser realizada em uma solicitação que esteja concluida.
- Uma solicitação só pode ser concluida se for antes fechada.
- Uma solicitação só pode ser fechada quando um oramento for aprovado.
- Uma Solicitação só pode conter um orçamento aprovado.
- O profissional não poderá agendar dois orçamentos na mesma data e horário.
