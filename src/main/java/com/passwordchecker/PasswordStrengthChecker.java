package com.passwordchecker;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Password Strength Checker Application
 * 
 * This application checks the strength of passwords and provides detailed feedback
 * on what makes a password weak, medium, or strong.
 */
public class PasswordStrengthChecker {
    
    // Regex patterns for password validation
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]");
    
    // Password strength thresholds
    private static final int MIN_LENGTH_WEAK = 6;
    private static final int MIN_LENGTH_MEDIUM = 8;
    private static final int MIN_LENGTH_STRONG = 12;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║         PASSWORD STRENGTH CHECKER APPLICATION             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        while (true) {
            System.out.println("Enter a password to check its strength (or 'quit' to exit):");
            System.out.print("> ");
            
            String password = scanner.nextLine();
            
            if (password.equalsIgnoreCase("quit")) {
                System.out.println("\nThank you for using Password Strength Checker!");
                break;
            }
            
            if (StringUtils.isBlank(password)) {
                System.out.println("\n⚠️  Password cannot be empty. Please try again.\n");
                continue;
            }
            
            PasswordStrength strength = checkPasswordStrength(password);
            displayResults(strength);
        }
        
        scanner.close();
    }
    
    /**
     * Checks the strength of a given password
     * 
     * @param password The password to check
     * @return PasswordStrength object containing strength level and feedback
     */
    public static PasswordStrength checkPasswordStrength(String password) {
        List<String> weaknesses = new ArrayList<>();
        List<String> strengths = new ArrayList<>();
        int score = 0;
        
        // Check length
        int length = password.length();
        if (length < MIN_LENGTH_WEAK) {
            weaknesses.add("Too short (minimum " + MIN_LENGTH_WEAK + " characters)");
        } else if (length < MIN_LENGTH_MEDIUM) {
            weaknesses.add("Could be longer (recommended " + MIN_LENGTH_MEDIUM + "+ characters)");
            score += 1;
        } else if (length < MIN_LENGTH_STRONG) {
            strengths.add("Good length (" + length + " characters)");
            score += 2;
        } else {
            strengths.add("Excellent length (" + length + " characters)");
            score += 3;
        }
        
        // Check for uppercase letters
        if (UPPERCASE_PATTERN.matcher(password).find()) {
            strengths.add("Contains uppercase letters");
            score += 1;
        } else {
            weaknesses.add("No uppercase letters");
        }
        
        // Check for lowercase letters
        if (LOWERCASE_PATTERN.matcher(password).find()) {
            strengths.add("Contains lowercase letters");
            score += 1;
        } else {
            weaknesses.add("No lowercase letters");
        }
        
        // Check for digits
        if (DIGIT_PATTERN.matcher(password).find()) {
            strengths.add("Contains numbers");
            score += 1;
        } else {
            weaknesses.add("No numbers");
        }
        
        // Check for special characters
        if (SPECIAL_CHAR_PATTERN.matcher(password).find()) {
            strengths.add("Contains special characters");
            score += 2;
        } else {
            weaknesses.add("No special characters");
        }
        
        // Check for common patterns
        if (containsCommonPatterns(password)) {
            weaknesses.add("Contains common patterns (e.g., '123', 'abc', 'password')");
            score -= 2;
        }
        
        // Check for repeated characters
        if (hasRepeatedCharacters(password)) {
            weaknesses.add("Contains repeated characters");
            score -= 1;
        }
        
        // Determine strength level based on score
        StrengthLevel level;
        if (score < 3) {
            level = StrengthLevel.WEAK;
        } else if (score < 6) {
            level = StrengthLevel.MEDIUM;
        } else {
            level = StrengthLevel.STRONG;
        }
        
        return new PasswordStrength(level, score, strengths, weaknesses);
    }
    
    /**
     * Checks if password contains common patterns
     */
    private static boolean containsCommonPatterns(String password) {
        String lowerPassword = password.toLowerCase();
        String[] commonPatterns = {
            "password", "123", "abc", "qwerty", "admin", "letmein",
            "welcome", "monkey", "dragon", "master", "sunshine"
        };
        
        for (String pattern : commonPatterns) {
            if (lowerPassword.contains(pattern)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Checks if password has 3 or more repeated characters in a row
     */
    private static boolean hasRepeatedCharacters(String password) {
        if (password.length() < 3) {
            return false;
        }
        
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && 
                password.charAt(i) == password.charAt(i + 2)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Displays the password strength results
     */
    private static void displayResults(PasswordStrength strength) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("PASSWORD STRENGTH ANALYSIS");
        System.out.println("═".repeat(60));
        
        // Display strength level with color-coded output
        System.out.print("Strength Level: ");
        switch (strength.getLevel()) {
            case WEAK:
                System.out.println("🔴 WEAK (Score: " + strength.getScore() + "/8)");
                break;
            case MEDIUM:
                System.out.println("🟡 MEDIUM (Score: " + strength.getScore() + "/8)");
                break;
            case STRONG:
                System.out.println("🟢 STRONG (Score: " + strength.getScore() + "/8)");
                break;
        }
        
        System.out.println("─".repeat(60));
        
        // Display strengths
        if (!strength.getStrengths().isEmpty()) {
            System.out.println("\n✓ Strengths:");
            for (String s : strength.getStrengths()) {
                System.out.println("  • " + s);
            }
        }
        
        // Display weaknesses
        if (!strength.getWeaknesses().isEmpty()) {
            System.out.println("\n✗ Issues Found:");
            for (String w : strength.getWeaknesses()) {
                System.out.println("  • " + w);
            }
        }
        
        // Provide recommendations
        System.out.println("\n💡 Recommendations:");
        if (strength.getLevel() == StrengthLevel.WEAK) {
            System.out.println("  • Use at least 8 characters");
            System.out.println("  • Mix uppercase and lowercase letters");
            System.out.println("  • Include numbers and special characters");
            System.out.println("  • Avoid common words and patterns");
        } else if (strength.getLevel() == StrengthLevel.MEDIUM) {
            System.out.println("  • Consider using 12+ characters for better security");
            System.out.println("  • Add more special characters");
            System.out.println("  • Avoid predictable patterns");
        } else {
            System.out.println("  • Your password is strong! Keep it secure.");
            System.out.println("  • Don't reuse this password on multiple sites");
            System.out.println("  • Consider using a password manager");
        }
        
        System.out.println("═".repeat(60) + "\n");
    }
    
    /**
     * Enum representing password strength levels
     */
    public enum StrengthLevel {
        WEAK, MEDIUM, STRONG
    }
    
    /**
     * Class to hold password strength analysis results
     */
    public static class PasswordStrength {
        private final StrengthLevel level;
        private final int score;
        private final List<String> strengths;
        private final List<String> weaknesses;
        
        public PasswordStrength(StrengthLevel level, int score, List<String> strengths, List<String> weaknesses) {
            this.level = level;
            this.score = score;
            this.strengths = strengths;
            this.weaknesses = weaknesses;
        }
        
        public StrengthLevel getLevel() {
            return level;
        }
        
        public int getScore() {
            return score;
        }
        
        public List<String> getStrengths() {
            return strengths;
        }
        
        public List<String> getWeaknesses() {
            return weaknesses;
        }
    }
}
