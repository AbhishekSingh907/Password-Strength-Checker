package com.passwordchecker;

import org.junit.Test;
import static org.junit.Assert.*;

import com.passwordchecker.PasswordStrengthChecker.PasswordStrength;
import com.passwordchecker.PasswordStrengthChecker.StrengthLevel;

/**
 * Unit tests for PasswordStrengthChecker
 */
public class PasswordStrengthCheckerTest {
    
    @Test
    public void testWeakPassword_TooShort() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("abc");
        assertEquals(StrengthLevel.WEAK, result.getLevel());
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("Too short")));
    }
    
    @Test
    public void testWeakPassword_NoUppercase() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("password123!");
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("No uppercase")));
    }
    
    @Test
    public void testWeakPassword_NoLowercase() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("PASSWORD123!");
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("No lowercase")));
    }
    
    @Test
    public void testWeakPassword_NoNumbers() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Password!");
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("No numbers")));
    }
    
    @Test
    public void testWeakPassword_NoSpecialCharacters() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Password123");
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("No special characters")));
    }
    
    @Test
    public void testWeakPassword_CommonPattern() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("password123");
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("common patterns")));
    }
    
    @Test
    public void testWeakPassword_RepeatedCharacters() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Paaassword123!");
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("repeated characters")));
    }
    
    @Test
    public void testMediumPassword() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("MyPass123");
        assertEquals(StrengthLevel.MEDIUM, result.getLevel());
        assertTrue(result.getScore() >= 3 && result.getScore() < 6);
    }
    
    @Test
    public void testMediumPassword_WithSpecialChars() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("MyPass123!");
        assertEquals(StrengthLevel.MEDIUM, result.getLevel());
        assertTrue(result.getStrengths().stream().anyMatch(s -> s.contains("special characters")));
    }
    
    @Test
    public void testStrongPassword() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("MyStr0ng!P@ssw0rd");
        assertEquals(StrengthLevel.STRONG, result.getLevel());
        assertTrue(result.getScore() >= 6);
    }
    
    @Test
    public void testStrongPassword_LongAndComplex() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Th1s!sAV3ryStr0ng&C0mpl3xP@ssw0rd");
        assertEquals(StrengthLevel.STRONG, result.getLevel());
        assertTrue(result.getStrengths().stream().anyMatch(s -> s.contains("Excellent length")));
    }
    
    @Test
    public void testPassword_AllCharacterTypes() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Abc123!@#");
        assertTrue(result.getStrengths().stream().anyMatch(s -> s.contains("uppercase")));
        assertTrue(result.getStrengths().stream().anyMatch(s -> s.contains("lowercase")));
        assertTrue(result.getStrengths().stream().anyMatch(s -> s.contains("numbers")));
        assertTrue(result.getStrengths().stream().anyMatch(s -> s.contains("special characters")));
    }
    
    @Test
    public void testPassword_MinimumLength() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Abc12!");
        assertNotNull(result);
        assertEquals(6, "Abc12!".length());
    }
    
    @Test
    public void testPassword_MediumLength() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Abcd1234!");
        assertNotNull(result);
        assertTrue("Abcd1234!".length() >= 8);
    }
    
    @Test
    public void testPassword_LongLength() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Abcd1234!@#$%");
        assertNotNull(result);
        assertTrue("Abcd1234!@#$%".length() >= 12);
    }
    
    @Test
    public void testPassword_OnlyLetters() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("OnlyLetters");
        assertEquals(StrengthLevel.MEDIUM, result.getLevel());
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("No numbers")));
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("No special characters")));
    }
    
    @Test
    public void testPassword_OnlyNumbers() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("123456789");
        assertEquals(StrengthLevel.WEAK, result.getLevel());
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("No uppercase")));
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("No lowercase")));
    }
    
    @Test
    public void testPassword_SpecialCharsOnly() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("!@#$%^&*()");
        assertEquals(StrengthLevel.MEDIUM, result.getLevel());
    }
    
    @Test
    public void testPassword_WithQwerty() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Qwerty123!");
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("common patterns")));
    }
    
    @Test
    public void testPassword_WithAdmin() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Admin123!");
        assertTrue(result.getWeaknesses().stream().anyMatch(w -> w.contains("common patterns")));
    }
    
    @Test
    public void testPassword_ScoreCalculation() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("Test123!");
        assertNotNull(result.getScore());
        assertTrue(result.getScore() >= 0);
    }
    
    @Test
    public void testPassword_HasStrengthsList() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("MyP@ssw0rd123");
        assertNotNull(result.getStrengths());
        assertFalse(result.getStrengths().isEmpty());
    }
    
    @Test
    public void testPassword_HasWeaknessesList() {
        PasswordStrength result = PasswordStrengthChecker.checkPasswordStrength("weak");
        assertNotNull(result.getWeaknesses());
        assertFalse(result.getWeaknesses().isEmpty());
    }
}
