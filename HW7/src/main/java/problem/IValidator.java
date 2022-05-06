package problem;

/**
 * Interface of generic class Validator.
 *
 * @param <T> - describes my type parameter
 */
public interface IValidator<T> {

  /**
   * Determines if the provided input meets the requirements.
   *
   * @param input - input data, its will either be String or Boolean
   * @return true if the provided input meets the requirements, otherwise return false
   */
  boolean isValid(T input);
}
