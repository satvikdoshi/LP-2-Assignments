#include <iostream>
#include <string>
#include <map>

using namespace std;

string curr_context;

class FruitInventory
{

public:
    map < string, map<string, string> inventory;

    FruitInventory()
    {

        inventory["apple"] = {{"color", "red"}, {"type", "fruit"}, {"price", "$2.00"}, {"usages", "snaks"}, {"benefits", "healthy"}};
        inventory["banana"] = {{"color", "red"}, {"type", "fruit"}, {"price", "$2.00"}, {"usages", "snaks"}, {"benefits", "healthy"}};
        inventory["orange"] = {{"color", "red"}, {"type", "fruit"}, {"price", "$2.00"}, {"usages", "snaks"}, {"benefits", "healthy"}};
        inventory["potato"] = {{"color", "red"}, {"type", "fruit"}, {"price", "$2.00"}, {"usages", "snaks"}, {"benefits", "healthy"}};
        inventory["carrot"] = {{"color", "red"}, {"type", "fruit"}, {"price", "$2.00"}, {"usages", "snaks"}, {"benefits", "healthy"}};
        inventory["tomato"] = {{"color", "red"}, {"type", "fruit"}, {"price", "$2.00"}, {"usages", "snaks"}, {"benefits", "healthy"}};
        inventory["current_item"] = { {"item", "None"} }
    }

    void handleUserInput(const string &userInput)
    {

        for (const auto &pair : inventory)
        {
            if (userInput.find(pair.first) != string::npos)
            {

                inventory["current_context"] = pair.second;
                curr_context = pair.first;

                cout << "chatbot: ";
                if (userInput == pair.first)
                {
                    cout << "color of " << pair.first << " is " << pair.second.at("color") << "." << endl;
                    cout << "Type of " << pair.first << " is " << pair.second.at("type") << "." << endl;
                    cout << "Price Per Kg of " << pair.first << " is " << pair.second.at("price") << "." << endl;
                    cout << "Usages of " << pair.first << " is " << pair.second.at("usages") << "." << endl;
                    cout << "Benefits of " << pair.first << " is " << pair.second.at("benefits") << "." << endl;
                }
                else
                {
                    int count = 0;
                    if (userInput.find("color") != string::npos)
                    {
                        cout << "Color of " << pair.first << " is " << pair.second.at("color") << "." << endl;
                        count++;
                    }

                }
                return;
            }
        }

        if(inventory["current_context"])
    }
}