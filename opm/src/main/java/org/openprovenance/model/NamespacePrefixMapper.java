package org.openprovenance.model;

/** Prefix definition for OPM serialisations. */


public class NamespacePrefixMapper extends com.sun.xml.bind.marshaller.NamespacePrefixMapper {
        // Must use 'internal' for Java 6
/* This file is a modification of the NamespacePrefixMapper from docx4j,
   which was licensed under Apache License, version 2.
*/
    String defaultNamespace;

    public NamespacePrefixMapper(String defaultNamespace) {
        this.defaultNamespace=defaultNamespace;
    }
       
    /**
     * Returns a preferred prefix for the given namespace URI.
     *
     * This method is intended to be overrided by a derived class.
     *
     * @param namespaceUri
     *      The namespace URI for which the prefix needs to be found.
     *      Never be null. "" is used to denote the default namespace.
     * @param suggestion
     *      When the content tree has a suggestion for the prefix
     *      to the given namespaceUri, that suggestion is passed as a
     *      parameter. Typically this value comes from QName.getPrefix()
     *      to show the preference of the content tree. This parameter
     *      may be null, and this parameter may represent an already
     *      occupied prefix.
     * @param requirePrefix
     *      If this method is expected to return non-empty prefix.
     *      When this flag is true, it means that the given namespace URI
     *      cannot be set as the default namespace.
     *
     * @return
     *      null if there's no preferred prefix for the namespace URI.
     *      In this case, the system will generate a prefix for you.
     *
     *      Otherwise the system will try to use the returned prefix,
     *      but generally there's no guarantee if the prefix will be
     *      actually used or not.
     *
     *      return "" to map this namespace URI to the default namespace.
     *      Again, there's no guarantee that this preference will be
     *      honored.
     *
     *      If this method returns "" when requirePrefix=true, the return
     *      value will be ignored and the system will generate one.
     */
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if (namespaceUri.equals("http://openprovenance.org/model/v1.01.a")) {
            return "opm";
        }
        if (namespaceUri.equals("http://openprovenance.org/model/extension/v1.01.a")) {
            return "opmext";
        }
        if (namespaceUri.equals("http://openprovenance.org/model/opmPrinterConfig")) {
            return "prn";
        }
        if (namespaceUri.equals("http://www.w3.org/2001/XMLSchema")) {
            return "xsd";
        }
        if (namespaceUri.equals("http://www.w3.org/2001/XMLSchema-instance")) {
            return "xsi";
        }
        if ((defaultNamespace!=null) && (namespaceUri.equals(defaultNamespace))) {
            return "";
        }
        return suggestion;
    }
   
    /**
     * Returns a list of namespace URIs that should be declared
     * at the root element.
     * <p>
     * By default, the JAXB RI produces namespace declarations only when
     * they are necessary, only at where they are used. Because of this
     * lack of look-ahead, sometimes the marshaller produces a lot of
     * namespace declarations that look redundant to human eyes. For example,
     * <pre><xmp>
     * <?xml version="1.0"?>
     * <root>
     *   <ns1:child xmlns:ns1="urn:foo"> ... </ns1:child>
     *   <ns2:child xmlns:ns2="urn:foo"> ... </ns2:child>
     *   <ns3:child xmlns:ns3="urn:foo"> ... </ns3:child>
     *   ...
     * </root>
     * <xmp></pre>
     * <p>
     * If you know in advance that you are going to use a certain set of
     * namespace URIs, you can override this method and have the marshaller
     * declare those namespace URIs at the root element.
     * <p>
     * For example, by returning <code>new String[]{"urn:foo"}</code>,
     * the marshaller will produce:
     * <pre><xmp>
     * <?xml version="1.0"?>
     * <root xmlns:ns1="urn:foo">
     *   <ns1:child> ... </ns1:child>
     *   <ns1:child> ... </ns1:child>
     *   <ns1:child> ... </ns1:child>
     *   ...
     * </root>
     * <xmp></pre>
     * <p>
     * To control prefixes assigned to those namespace URIs, use the
     * {@link #getPreferredPrefix} method.
     *
     * @return
     *      A list of namespace URIs as an array of {@link String}s.
     *      This method can return a length-zero array but not null.
     *      None of the array component can be null. To represent
     *      the empty namespace, use the empty string <code>""</code>.
     *
     * @since
     *      JAXB RI 1.0.2
     */
    public String[] getPreDeclaredNamespaceUris() {
        if (defaultNamespace!=null) {
            return new String[] { "http://www.w3.org/2001/XMLSchema-instance",
                                  "http://www.w3.org/2001/XMLSchema",
                                  defaultNamespace};
        } else {
            return new String[] { "http://www.w3.org/2001/XMLSchema-instance",
                                  "http://www.w3.org/2001/XMLSchema"};
        }
    }

   
}