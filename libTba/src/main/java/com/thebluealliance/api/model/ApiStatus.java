/**
 * The Blue Alliance API
 * Access data about the FIRST Robotics Competition
 *
 * OpenAPI spec version: 2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.thebluealliance.api.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;


/**
 * ApiStatus
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-08-09T14:16:34.746-04:00")
public class ApiStatus   {
  @SerializedName("champsPitLocationsUrl")
  private String champsPitLocationsUrl = null;

  @SerializedName("downEvents")
  private List<String> downEvents = new ArrayList<String>();

  @SerializedName("fmsApiDown")
  private Boolean fmsApiDown = null;

  @SerializedName("hasMessage")
  private Boolean hasMessage = null;

  @SerializedName("lastModified")
  private Long lastModified = null;

  @SerializedName("latestAppVersion")
  private Integer latestAppVersion = null;

  @SerializedName("maxSeason")
  private Integer maxSeason = null;

  @SerializedName("messageText")
  private String messageText = null;

  @SerializedName("minAppVersion")
  private Integer minAppVersion = null;

  public ApiStatus champsPitLocationsUrl(String champsPitLocationsUrl) {
    this.champsPitLocationsUrl = champsPitLocationsUrl;
    return this;
  }

   /**
   * Location of data file for CMP pits
   * @return champsPitLocationsUrl
  **/
  @ApiModelProperty(example = "null", value = "Location of data file for CMP pits")
  @Nullable
  public String getChampsPitLocationsUrl() {
    return champsPitLocationsUrl;
  }

  public void setChampsPitLocationsUrl(String champsPitLocationsUrl) {
    this.champsPitLocationsUrl = champsPitLocationsUrl;
  }

  public ApiStatus downEvents(List<String> downEvents) {
    this.downEvents = downEvents;
    return this;
  }

  public ApiStatus addDownEventsItem(String downEventsItem) {
    this.downEvents.add(downEventsItem);
    return this;
  }

   /**
   * A list of event keys that are not publishing data
   * @return downEvents
  **/
  @ApiModelProperty(example = "null", value = "A list of event keys that are not publishing data")
  @Nullable
  public List<String> getDownEvents() {
    return downEvents;
  }

  public void setDownEvents(List<String> downEvents) {
    this.downEvents = downEvents;
  }

  public ApiStatus fmsApiDown(Boolean fmsApiDown) {
    this.fmsApiDown = fmsApiDown;
    return this;
  }

   /**
   * Is FIRST's datafeed down?
   * @return fmsApiDown
  **/
  @ApiModelProperty(example = "null", value = "Is FIRST's datafeed down?")
  @Nullable
  public Boolean getFmsApiDown() {
    return fmsApiDown;
  }

  public void setFmsApiDown(Boolean fmsApiDown) {
    this.fmsApiDown = fmsApiDown;
  }

  public ApiStatus hasMessage(Boolean hasMessage) {
    this.hasMessage = hasMessage;
    return this;
  }

   /**
   * Is there an admin message to show?
   * @return hasMessage
  **/
  @ApiModelProperty(example = "null", value = "Is there an admin message to show?")
  @Nullable
  public Boolean getHasMessage() {
    return hasMessage;
  }

  public void setHasMessage(Boolean hasMessage) {
    this.hasMessage = hasMessage;
  }

  public ApiStatus lastModified(Long lastModified) {
    this.lastModified = lastModified;
    return this;
  }

   /**
   * Timestamp this model was last modified
   * @return lastModified
  **/
  @ApiModelProperty(example = "null", value = "Timestamp this model was last modified")
  @Nullable
  public Long getLastModified() {
    return lastModified;
  }

  public void setLastModified(Long lastModified) {
    this.lastModified = lastModified;
  }

  public ApiStatus latestAppVersion(Integer latestAppVersion) {
    this.latestAppVersion = latestAppVersion;
    return this;
  }

   /**
   * Newest app version code
   * @return latestAppVersion
  **/
  @ApiModelProperty(example = "null", value = "Newest app version code")
  @Nullable
  public Integer getLatestAppVersion() {
    return latestAppVersion;
  }

  public void setLatestAppVersion(Integer latestAppVersion) {
    this.latestAppVersion = latestAppVersion;
  }

  public ApiStatus maxSeason(Integer maxSeason) {
    this.maxSeason = maxSeason;
    return this;
  }

   /**
   * Max year we have data for
   * @return maxSeason
  **/
  @ApiModelProperty(example = "null", value = "Max year we have data for")
  @Nullable
  public Integer getMaxSeason() {
    return maxSeason;
  }

  public void setMaxSeason(Integer maxSeason) {
    this.maxSeason = maxSeason;
  }

  public ApiStatus messageText(String messageText) {
    this.messageText = messageText;
    return this;
  }

   /**
   * Admin message
   * @return messageText
  **/
  @ApiModelProperty(example = "null", value = "Admin message")
  @Nullable
  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public ApiStatus minAppVersion(Integer minAppVersion) {
    this.minAppVersion = minAppVersion;
    return this;
  }

   /**
   * Lowest allowed app version code
   * @return minAppVersion
  **/
  @ApiModelProperty(example = "null", value = "Lowest allowed app version code")
  @Nullable
  public Integer getMinAppVersion() {
    return minAppVersion;
  }

  public void setMinAppVersion(Integer minAppVersion) {
    this.minAppVersion = minAppVersion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiStatus apiStatus = (ApiStatus) o;
    return Objects.equals(this.champsPitLocationsUrl, apiStatus.champsPitLocationsUrl) &&
        Objects.equals(this.downEvents, apiStatus.downEvents) &&
        Objects.equals(this.fmsApiDown, apiStatus.fmsApiDown) &&
        Objects.equals(this.hasMessage, apiStatus.hasMessage) &&
        Objects.equals(this.lastModified, apiStatus.lastModified) &&
        Objects.equals(this.latestAppVersion, apiStatus.latestAppVersion) &&
        Objects.equals(this.maxSeason, apiStatus.maxSeason) &&
        Objects.equals(this.messageText, apiStatus.messageText) &&
        Objects.equals(this.minAppVersion, apiStatus.minAppVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(champsPitLocationsUrl, downEvents, fmsApiDown, hasMessage, lastModified, latestAppVersion, maxSeason, messageText, minAppVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiStatus {\n");
    
    sb.append("    champsPitLocationsUrl: ").append(toIndentedString(champsPitLocationsUrl)).append("\n");
    sb.append("    downEvents: ").append(toIndentedString(downEvents)).append("\n");
    sb.append("    fmsApiDown: ").append(toIndentedString(fmsApiDown)).append("\n");
    sb.append("    hasMessage: ").append(toIndentedString(hasMessage)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    latestAppVersion: ").append(toIndentedString(latestAppVersion)).append("\n");
    sb.append("    maxSeason: ").append(toIndentedString(maxSeason)).append("\n");
    sb.append("    messageText: ").append(toIndentedString(messageText)).append("\n");
    sb.append("    minAppVersion: ").append(toIndentedString(minAppVersion)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
