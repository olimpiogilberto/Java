/*******************************************************************************
 * Autor: Adriano Pamplona
 * Data de cria��o: 01/05/2007
 * Vers�o: 1.0.0
 *******************************************************************************
 * Objetivo: 
 *		Fun��es para uso da pagina��o.
 *******************************************************************************
 * Depend�ncias: 
 *		Nenhuma
 *******************************************************************************
 * m�todos do objeto:
 *		acaoLinkPagina(formulario, acao, parametro, pagina)
 *******************************************************************************
 * Exemplo:
 * 		N/A
 *******************************************************************************
 */

/**
 * Fun��o respons�vel pela submiss�o ao clicar no link da pagina��o.
 * 
 * @formulario
 * @acao
 * @parametro
 * @pagina
 */
function acaoLinkPagina(formulario, acao, parametro, pagina) {
	formulario = document.getElementsByName(formulario)[0];
	formulario.action = acao;
	formulario[parametro].value = pagina;
	formulario.submit();
}
