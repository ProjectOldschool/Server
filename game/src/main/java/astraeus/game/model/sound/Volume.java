// Generated by delombok at Sat Feb 25 09:19:10 PST 2017
package astraeus.game.model.sound;

/**
 * An enumeration of the volume levels in-game.
 *
 * @author Seven
 */
public enum Volume {
  SILENT(4),
  QUIET(3),
  NORMAL(2),
  HIGH(1),
  LOUD(0);
  private final int code;

  private Volume(int code) {
    this.code = code;
  }

  @java.lang.SuppressWarnings("all")
  @javax.annotation.Generated("lombok")
  public int getCode() {
    return this.code;
  }
}