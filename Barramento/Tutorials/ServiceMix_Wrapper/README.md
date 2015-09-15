# Como adicionar o ServiceWrapper do Karaf no Raspberry Pi
--

## Porque isso é necessário?

Apesar do Karaf já possuir um Wrapper e ele poder ser facilmente instalado
o mesmo não é compatível com processadores ARM e após instalado sempre
apresenta um erro de compatibilidade causada pelo fato da compilação do
wrapper não é cross-platform.

Só para ficar claro qual o erro apresentado, você deve ver algo dessa forma:

```sh
$KARAF_HOME/bin/karaf-wrapper: 1: $KARAF_HOME/bin/karaf-wrapper: Syntax error: "(" unexpected
```

## Como resolvo então?

Para resolver é fácil é só você concertar o código compilar com suporte para
outras plataformas e acabou. Bem isso não parece fácil e realmente na prática
não é mas vamos ao passos necessários para fazer o mesmo funcionar no Raspberry Pi.
Primeiramente um agradecimento ao usuario `David Smith` que apresentou a dica na
paǵina de erros da apache em resposta a esta issue **[this link](https://issues.apache.org/jira/browse/KARAF-2734)** (https://issues.apache.org/jira/browse/KARAF-2734).
Como pode ver a solução que ele apresenta funcionou no Beagle Bone Black mas e quanto
ao Raspberry Pi, será que teremos a mesma sorte?

Bem foi isso que eu me perguntei, então vamos a nossa experiência.
A primeira coisa a ser feita foi baixar o JDK para embarcados presentes no site da
ORACLE, estranhamente a versão 1.7 não está disponivel mas isso não vem a ser um problema,
só um aviso você pode pular essa parte e ir para a parte do reparo caso queira

--
<p align="center">
	Developed by </br>
	Authors: <b> Alana Souza / Jeferson Lima</b>  </br>
  <img src="https://wiki.dcc.ufba.br/pub/SmartUFBA/ProjectLogo/wiserufbalogo.jpg"/>
</p>

