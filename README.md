# INspire

__IMPORTANT__
The server addresses are hardcoded. To change the server settings
between development and production, change the following file and rebuild the APK:

https://github.com/nbiimobilab/inspire/blob/master/frontend/app/src/main/res/values/configuration.xml

In the file is a section as follows, which points to a test server:

```xml
<string name="active_server">@string/test_server</string>
<string name="active_events_feed">@string/test_events_feed</string>
<string name="active_news_feed">@string/test_news_feed</string>

Change as follows in order to point to the production server (nbiimobilab.com):

```xml
<string name="active_server">@string/production_server</string>
<string name="active_events_feed">@string/production_events_feed</string>
<string name="active_news_feed">@string/production_news_feed</string>
