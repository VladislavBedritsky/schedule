package org.kek.data.service;

/**
 *
 * Service which processes url data
 *
 * @version 1.01 22 Jul 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface UrlService {

    /**
     * This function is processing json from REST url into string.
     *
     * @param url REST url
     * @return json in type String
     */
    String getJsonInTypeStringFromRestUrl(String url);

}
