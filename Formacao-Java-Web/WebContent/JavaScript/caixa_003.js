/**
 * Biblioteca para opera��es gen�ricas.
 *
 * Namespace: caixa.util.
 *
 * @author <a href="mailto:mario.f.ferreira@caixa.gov.br">M�rio S�rgio Fujikawa Ferreira
 *         <mario.f.ferreira@caixa.gov.br> (C101038)</a>
 */

/**
 * Cria namespace caixa.
 */
if (caixa == null)
	var caixa = {};

/**
 * Cria namespace caixa.util.
 */
if (caixa.util == null)
	caixa.util = {};

/**
 * Verifica se uma declara��o JavaScript est� definida. Ou seja, n�o est� <code>undefined</code> e n�o � <code>null</code>.
 *
 * Namespace: caixa.util
 * M�todo: isNeitherUndefinedNorNull
 */
if (caixa.util.isNeitherUndefinedNorNull == null) {
	caixa.util.isNeitherUndefinedNorNull = function(statement) {
		return ((statement !== undefined) && (statement != null));
	};
}

/**
 * Complementa o comportamento <code>typeof</code> do JavaScript padr�o. Corrige o retorno incorreto quando utilizado
 * com refer�ncias a objetos <code>Array</code> e refer�ncia <code>null</code>.
 *
 * <pre>
 * - Se utilizar typeOf em uma refer�ncia a um objeto Array ser� produzido 'Array' ao inv�s de 'object' como ditado por
 *   typeof.
 * - Se utilizar typeOf em refer�ncia null ser� produzido 'null' ao inv�s de 'object' como ditado por typeof.
 * </pre>
 *  
 * Namespace: caixa.util
 * M�todo: typeOf
 *
 * Obtido em: Crockford, Douglas. Remedial JavaScript. Dispon�vel em: <http://javascript.crockford.com/remedial.html>.
 *            Acesso em: 13 ago. 2009.
 */
if (caixa.util.typeOf == null) {
	caixa.util.typeOf = function(object) {
		var s = typeof object;
		if (s === 'object') {
			if (object) {
				if (
					typeof object.length === 'number' &&
					!(object.propertyIsEnumerable('length')) &&
					typeof object.splice === 'function'
					)
				{
					s = 'array';
				}
			} else {
				s = 'null';
			}
		}
		return s;
	};
}

/**
 * Verifica se uma refer�ncia de objeto � de um objeto do tipo <code>Boolean</code>.
 *
 * Namespace: caixa.util
 * M�todo: isBoolean
 */
if (caixa.util.isBoolean == null) {
	caixa.util.isBoolean = function(object) {
		return (typeof(object) === 'boolean');
	};
}