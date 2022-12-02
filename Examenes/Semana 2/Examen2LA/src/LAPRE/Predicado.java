package LAPRE;

//Creamos nuestra interface funcional
@FunctionalInterface
public interface Predicado<T> {

	abstract boolean probar(T t);
}
