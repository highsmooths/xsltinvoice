<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Invoices</title>
            </head>
            <body>
                <h1>Your Invoices</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Description</th>
                            <th>Target Date</th>
                            <th>Done</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="invoices/invoice">
                            <tr>
                                <td><xsl:value-of select="username"/></td>
                                <td><xsl:value-of select="description"/></td>
                                <td><xsl:value-of select="targetDate"/></td>
                                <td><xsl:value-of select="done"/></td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
