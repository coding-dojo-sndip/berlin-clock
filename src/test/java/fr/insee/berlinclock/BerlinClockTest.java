package fr.insee.berlinclock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.Assert;
import org.junit.Test;

public class BerlinClockTest {

    BerlinClock berlinClock = new BerlinClock();

    // Top hours should have 4 lamps
    @Test
    public void testTopHoursShouldHave4Lamps() {
        assertThat(berlinClock.getTopHours(7).length()).isEqualTo(4);
    }

    // Top hours should light a red lamp for every 5 hours
    @Test
    public void testTopHoursShouldLightRedLampForEvery5Hours() {
        assertThat(berlinClock.getTopHours(0)).isEqualTo("OOOO");
        assertThat(berlinClock.getTopHours(13)).isEqualTo("RROO");
        assertThat(berlinClock.getTopHours(23)).isEqualTo("RROO");
        assertThat(berlinClock.getTopHours(24)).isEqualTo("RRRR");
    }

    @Test
    public void testTopHoursshouldThrowsIAE() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> berlinClock.getTopHours(40));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> berlinClock.getTopHours(-5));
    }

    // Bottom hours should have 4 lamps
    @Test
    public void testBottomHoursShouldHave4Lamps() {
        assertThat(berlinClock.getBottomHours(5).length()).isEqualTo(4);
    }

    // Bottom hours should light a red lamp for every hour left from top hours
    @Test
    public void testBottomHoursShouldLightRedLampForEveryHourLeftFromTopHours() {
        assertThat(berlinClock.getBottomHours(0)).isEqualTo("OOOO");
        assertThat(berlinClock.getBottomHours(13)).isEqualTo("RRRO");
        assertThat(berlinClock.getBottomHours(23)).isEqualTo("RRRO");
        assertThat(berlinClock.getBottomHours(24)).isEqualTo("RRRR");
    }

    @Test
    public void testBottomHoursthrowsIAE() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> berlinClock.getTopHours(40));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> berlinClock.getTopHours(-5));
    }

    // Top minutes should have 11 lamps
    @Test
    public void testTopMinutesShouldHave11Lamps() {

        assertThat(berlinClock.getTopMinutes(34).length()).isEqualTo(11);
    }

    // Top minutes should have 3rd, 6th and 9th lamps in red to indicate first
    // quarter, half and last quarter
    @Test
    public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
        String minutes32 = berlinClock.getTopMinutes(32);
        Assert.assertEquals("R", minutes32.substring(2, 3));
        Assert.assertEquals("R", minutes32.substring(5, 6));
        Assert.assertEquals("O", minutes32.substring(8, 9));
    }

    // Top minutes should light a yellow lamp for every 5 minutes unless it's
    // first quarter, half or last quarter
    @Test
    public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
        Assert.assertEquals("OOOOOOOOOOO", berlinClock.getTopMinutes(0));
        Assert.assertEquals("YYROOOOOOOO", berlinClock.getTopMinutes(17));
        Assert.assertEquals("YYRYYRYYRYY", berlinClock.getTopMinutes(59));
    }

    @Test
    public void testTopMinutesthrowsIAE() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> berlinClock.getTopMinutes(60));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> berlinClock.getTopHours(-400));
    }

    // Bottom minutes should have 4 lamps
    @Test
    public void testBottomMinutesShouldHave4Lamps() {
        Assert.assertEquals(4, berlinClock.getBottomMinutes(0).length());
    }

    // Bottom minutes should light a yellow lamp for every minute left from top
    // minutes
    @Test
    public void testBottomMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
        Assert.assertEquals("OOOO", berlinClock.getBottomMinutes(0));
        Assert.assertEquals("YYOO", berlinClock.getBottomMinutes(17));
        Assert.assertEquals("YYYY", berlinClock.getBottomMinutes(59));
    }

    // Berlin Clock should result in array with 4 elements
    @Test
    public void testBerlinClockShouldResultInArrayWith4Elements() {
        assertThat(berlinClock.convertToBerlinTime("13:17").length).isEqualTo(4);
    }

    // Berlin Clock it should "result in correct seconds, hours and minutes" in
    // {
    @Test
    public void testBerlinClockShouldResultInCorrectSecondsHoursAndMinutes() {

        assertThat(berlinClock.convertToBerlinTime("16:37")).containsExactly("RRRO", "ROOO", "YYRYYRYOOOO", "YYOO");
    }

    @Test
    public void testBerlinClockShouldthrowIAE() {
        assertThatIllegalArgumentException().isThrownBy(() -> berlinClock.convertToBerlinTime("16:37:55"));
        assertThatIllegalArgumentException().isThrownBy(() -> berlinClock.convertToBerlinTime("null"));
        assertThatIllegalArgumentException().isThrownBy(() -> berlinClock.convertToBerlinTime("-1:52"));
        assertThatIllegalArgumentException().isThrownBy(() -> berlinClock.convertToBerlinTime("25:62"));

    }
}