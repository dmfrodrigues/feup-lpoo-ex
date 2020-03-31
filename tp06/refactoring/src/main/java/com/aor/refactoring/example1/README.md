# Code smells

- Product:
    - Dead code (setters)
- OrderLine:
    - Innapropriate Intimacy (public fields)
    - Feature Envy (all methods)
- Order:
    - Code duplication (for cycle to calculate total)
    - Long method name (isElegibleForFreeDelivery)
    - Primitive obcession (instead of asking line to give string, determined all the string)
    - Switch statements (if condition is true, return true, otherwise return false, in isEligible)
