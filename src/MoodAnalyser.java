public class MoodAnalyser {
    private String message;

    /*
     * @name : MoodAnalyser
     * @desc: Default constructor
     */
    public MoodAnalyser() {
        this.message = ""; // Default empty message
    }

    /*
     * @name : MoodAnalyser
     * @desc: Parameterized constructor
     * @param: message: String
     */
    public MoodAnalyser(String message) {
        this.message = message;
    }

    /*
     * @name : analyseMood
     * @desc: Method to analyse the mood using the message field
     * @return: Mood
     */
    public Mood analyseMood() throws MoodException, Mood {
        try {
            if (message == null) {
                throw new MoodException("Invalid mood: Message cannot be null", MoodErrors.NULL_MESSAGE);
            } else if (message.trim().isEmpty()) {
                throw new MoodException("Invalid mood: Message cannot be empty", MoodErrors.EMPTY_MESSAGE);
            }

            if (message.toLowerCase().contains("sad")) {
                return new Mood(Mood.MoodType.SAD);
            } else {
                return new Mood(Mood.MoodType.HAPPY);
            }
        } catch (NullPointerException e) {
            // Handle null scenario and throw MoodAnalysisException
            throw new MoodException("Invalid mood: Message cannot be null", MoodErrors.NULL_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            Mood mood = moodAnalyser.analyseMood();
            System.out.println("Mood : " + mood.getMood());
        } catch (MoodException | Mood e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
