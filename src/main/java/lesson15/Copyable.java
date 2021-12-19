package lesson15;

public interface Copyable<T> {

    T copy(T origin, int copyCount);
}
