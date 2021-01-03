package org.assertj.examples.data;

/**
 * {@link TolkienCharacter} specific assertions - Generated by CustomAssertionGenerator.
 *
 * <p>Although this class is not final to allow Soft assertions proxy, if you wish to extend it,
 * extend {@link AbstractTolkienCharacterAssert} instead.
 */
@javax.annotation.Generated(value = "assertj-assertions-generator")
public class TolkienCharacterAssert
        extends AbstractTolkienCharacterAssert<TolkienCharacterAssert, TolkienCharacter> {

    /**
     * Creates a new <code>{@link TolkienCharacterAssert}</code> to make assertions on actual
     * TolkienCharacter.
     *
     * @param actual the TolkienCharacter we want to make assertions on.
     */
    public TolkienCharacterAssert(TolkienCharacter actual) {
        super(actual, TolkienCharacterAssert.class);
    }

    /**
     * An entry point for TolkienCharacterAssert to follow AssertJ standard <code>assertThat()
     * </code> statements.<br>
     * With a static import, one can write directly: <code>assertThat(myTolkienCharacter)</code> and
     * get specific assertion with code completion.
     *
     * @param actual the TolkienCharacter we want to make assertions on.
     * @return a new <code>{@link TolkienCharacterAssert}</code>
     */
    @org.assertj.core.util.CheckReturnValue
    public static TolkienCharacterAssert assertThat(TolkienCharacter actual) {
        return new TolkienCharacterAssert(actual);
    }
}
