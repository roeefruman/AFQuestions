import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class cosineSimilarityTest {

    @Test
    void cosineSimilarity() {
        // a few perfect matches
        // multi word
        assertEquals(1D,cosineSimilarity.cosineSimilarity("Cosine similarity is a common vector based similarity measure similar to dice coefficient", "Cosine similarity is a common vector based similarity measure similar to dice coefficient".split("\\W+")), 0.00001D);
        // single word
        assertEquals(1D,cosineSimilarity.cosineSimilarity("Cosine", "Cosine".split("\\W+")), 0.00001D);
        // empty
        assertEquals(1D,cosineSimilarity.cosineSimilarity("", "".split("\\W+")), 0.00001D);
        // same words mix order
        assertEquals(1D,cosineSimilarity.cosineSimilarity("Cosine one two three", "one three Cosine two".split("\\W+")), 0.00001D);
        // longer mix word order
        assertEquals(1D,cosineSimilarity.cosineSimilarity("Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice coefficient", "similarity Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based measure similar to dice Cosine similarity is measure a common vector based similarity similar to dice coefficient".split("\\W+")), 0.00001D);
        // same words mix order
        assertEquals(1D,cosineSimilarity.cosineSimilarity("Cosine one two three", "one three Cosine two".split("\\W+")), 0.00001D);
        // longer mix word order
        assertEquals(1D,cosineSimilarity.cosineSimilarity("Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice coefficient", "similarity Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based similarity measure similar to dice Cosine similarity is a common vector based measure similar to dice Cosine similarity is measure a common vector based similarity similar to dice coefficient".split("\\W+")), 0.00001D);
        // ===============================================================
        // no matching words
        assertEquals(0D,cosineSimilarity.cosineSimilarity("Cosine", "hope".split("\\W+")), 0.00001D);
        // empty
        assertEquals(0D,cosineSimilarity.cosineSimilarity("", "last".split("\\W+")), 0.00001D);
        assertEquals(0D,cosineSimilarity.cosineSimilarity("first", "".split("\\W+")), 0.00001D);


        // one matching word one non-match words (1,1) - (1,0) => 0.7071
        assertEquals(0.707106D,cosineSimilarity.cosineSimilarity("Cosine", "Cosine hope".split("\\W+")), 0.00001D);

        // a few mixed sentences
        assertEquals(0.86164D,cosineSimilarity.cosineSimilarity("This is a foo bar sentence .", "This sentence is similar to a foo bar sentence .".split("\\W+")), 0.00001D);
        assertEquals(0.07453D,cosineSimilarity.cosineSimilarity("Cosine similarity is a common vector based similarity measure similar to dice coefficient", "The Levenshtein distance between two strings is defined as the minimum number".split("\\W+")),0.00001D);
        assertEquals(0.1443375D,cosineSimilarity.cosineSimilarity("He is the hero Gotham deserves", "but not the one it needs right now.".split("\\W+")),0.00001D);
    }
}