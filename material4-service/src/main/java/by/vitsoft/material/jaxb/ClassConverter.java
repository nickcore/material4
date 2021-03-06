package by.vitsoft.material.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

final public class ClassConverter extends XmlAdapter<String, Class> {

    /**
     * <p>
     * Convert the string argument into a BigInteger value.
     * @param lexicalXSDInteger
     *     A string containing a lexical representation of
     *     xsd:integer.
     * @return
     *     A BigInteger value represented by the string argument.
     * @throws IllegalArgumentException <code>lexicalXSDInteger</code> is not a valid string representation of a {@link java.lang.Class} value.
     */
    public static Class<?> parseClassName(String lexicalXSDInteger) {
        try {
            return Class.forName(lexicalXSDInteger);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Error class name: "+lexicalXSDInteger);
        }
    }

    /**
     * <p>
     * Converts a Class value into a string.
     * @param val  A Class value
     * @return     A string containing a lexical representation of xsd:integer
     * @throws IllegalArgumentException <tt>val</tt> is null.
     */
    public static String printClass(Class val ) {
        if (val == null) {
            throw new IllegalArgumentException("Class is null");
        }
        return val.toString();
    }

    @Override
    public Class unmarshal(String v) throws Exception {
        return parseClassName(v);
    }

    @Override
    public String marshal(Class v) throws Exception {
        return printClass(v);
    }
}
