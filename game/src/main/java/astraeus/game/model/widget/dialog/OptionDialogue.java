// Generated by delombok at Sat Feb 25 09:19:10 PST 2017
package astraeus.game.model.widget.dialog;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link Chainable} implementation that represents a dialogue in which options are given to the
 * player.
 *
 * @author Vult-R
 */
public final class OptionDialogue implements Chainable {
  
  /**
   * The text for this dialogue.
   */
  private final String[] lines;
  
  /**
   * The list of actions for this dialogue.
   */
  private final List<Runnable> actions = new ArrayList<>();

  /**
   * Creates a new {@link OptionDialogue}.
   *
   * @param option1 The text for the first option.
   *
   * @param action1 The action for the first action.
   *
   * @param option2 The text for the second option.
   *
   * @param action2 The action for the second action.
   */
  public OptionDialogue(String option1, Runnable action1, String option2, Runnable action2) {
    lines = new String[]{option1, option2};
    actions.add(action1);
    actions.add(action2);
  }

  /**
   * Creates a new {@link OptionDialogue}.
   *
   * @param option1 The text for the first option.
   *
   * @param action1 The action for the first action.
   *
   * @param option2 The text for the second option.
   *
   * @param action2 The action for the second action.
   *
   * @param option3 The text for the third option.
   *
   * @param action3 The action for the third action.
   */
  public OptionDialogue(String option1, Runnable action1, String option2, Runnable action2, String option3, Runnable action3) {
    lines = new String[]{option1, option2, option3};
    actions.add(action1);
    actions.add(action2);
    actions.add(action3);
  }

  /**
   * Creates a new {@link OptionDialogue}.
   *
   * @param option1 The text for the first option.
   *
   * @param action1 The action for the first action.
   *
   * @param option2 The text for the second option.
   *
   * @param action2 The action for the second action.
   *
   * @param option3 The text for the third option.
   *
   * @param action3 The action for the third action.
   *
   * @param option4 The text for the four option.
   *
   * @param action4 The action for the four action.
   */
  public OptionDialogue(String option1, Runnable action1, String option2, Runnable action2, String option3, Runnable action3, String option4, Runnable action4) {
    lines = new String[]{option1, option2, option3, option4};
    actions.add(action1);
    actions.add(action2);
    actions.add(action3);
    actions.add(action4);
  }

  /**
   * Creates a new {@link OptionDialogue}.
   *
   * @param option1 The text for the first option.
   *
   * @param action1 The action for the first action.
   *
   * @param option2 The text for the second option.
   *
   * @param action2 The action for the second action.
   *
   * @param option3 The text for the third option.
   *
   * @param action3 The action for the third action.
   *
   * @param option4 The text for the four option.
   *
   * @param action4 The action for the four action.
   *
   * @param option5 The text for the fifth option.
   *
   * @param action5 The action for the fifth action.
   */
  public OptionDialogue(String option1, Runnable action1, String option2, Runnable action2, String option3, Runnable action3, String option4, Runnable action4, String option5, Runnable action5) {
    lines = new String[]{option1, option2, option3, option4, option5};
    actions.add(action1);
    actions.add(action2);
    actions.add(action3);
    actions.add(action4);
    actions.add(action5);
  }

  @Override
  public void accept(DialogueFactory factory) {
    factory.sendOption(this);
  }

  /**
   * The text for this dialogue.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public String[] getLines() {
    return this.lines;
  }

  /**
   * The list of actions for this dialogue.
   */
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public List<Runnable> getActions() {
    return this.actions;
  }

  @java.lang.Override
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public boolean equals(final java.lang.Object o) {
    if (o == this) return true;
    if (!(o instanceof OptionDialogue)) return false;
    final OptionDialogue other = (OptionDialogue)o;
    if (!java.util.Arrays.deepEquals(this.getLines(), other.getLines())) return false;
    final java.lang.Object this$actions = this.getActions();
    final java.lang.Object other$actions = other.getActions();
    if (this$actions == null ? other$actions != null : !this$actions.equals(other$actions)) return false;
    return true;
  }

  @java.lang.Override
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getLines());
    final java.lang.Object $actions = this.getActions();
    result = result * PRIME + ($actions == null ? 0 : $actions.hashCode());
    return result;
  }

  @java.lang.Override
  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public java.lang.String toString() {
    return "OptionDialogue(lines=" + java.util.Arrays.deepToString(this.getLines()) + ", actions=" + this.getActions() + ")";
  }
}