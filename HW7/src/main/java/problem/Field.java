package problem;

import java.util.Objects;

/**
 * Generic class Field can accept different types of input from users and be used to create a
 * variety of forms.
 *
 * @param <T> - describes my type parameter
 */
public class Field<T> {

  private String label;
  private T value;
  private Boolean required;
  private Validator<T> validator;

  /**
   * Constructor for Class Field. When a Field is first instantiated, value should be null.
   *
   * @param label     - the String label associated with the form field
   * @param required  - a boolean indicating whether a particular field must be completed before the
   *                  form can be submitted
   * @param validator - a Validator that will perform input validation
   */
  public Field(String label, Boolean required, Validator<T> validator) {
    this.label = label;
    this.required = required;
    this.value = null;
    this.validator = validator;
  }

  /**
   * Getter for label
   *
   * @return the label, as String
   */
  public String getLabel() {
    return label;
  }

  /**
   * Getter for value
   *
   * @return the value, as String or Boolean
   */
  public T getValue() {
    return value;
  }

  /**
   * Getter for if required
   *
   * @return true if the field is required, otherwise return false
   */
  public Boolean getRequired() {
    return required;
  }

  /**
   * Getter for validator
   *
   * @return the validator, as Validator
   */
  public Validator<T> getValidator() {
    return validator;
  }

  /**
   * Update the Field’s value if the input is valid according to the validator. If input is not
   * valid, throw an exception and do not update value.
   *
   * @param input - input data, its type will either be String or Boolean
   * @throws InvalidInputException if the type of input is neither String nor Boolean or invalid
   *                               according to the validator
   */
  public void updateValue(T input) throws InvalidInputException {
    // throw an exception if the input is invalid according to the validator
    if (!this.validator.isValid(input)) {
      throw new InvalidInputException("This input is not valid according to the validator");
    }
    // update the value
    this.value = input;
  }

  /**
   * Return true if the Field has been filled out. Client code can use this method to determine if a
   * form is ready to submit.
   *
   * @return true if the Field has been filled out, otherwise return false
   */
  public boolean isFilled() {
    // the Field is required and its value meets the requirements specified by its validator
    if (this.required && this.validator.isValid(this.value)) {
      return true;
    }
    // the Field is optional (it does not matter what the Field’s value is in this case)
    if (!this.required) {
      return true;
    }
    return false;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o - the reference object with which to compare.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Field<?> field = (Field<?>) o;
    return Objects.equals(label, field.label) && Objects.equals(value,
        field.value) && Objects.equals(required, field.required)
        && Objects.equals(validator, field.validator);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(label, value, required, validator);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Field{" +
        "label='" + label + '\'' +
        ", value=" + value +
        ", required=" + required +
        ", validator=" + validator +
        '}';
  }
}
