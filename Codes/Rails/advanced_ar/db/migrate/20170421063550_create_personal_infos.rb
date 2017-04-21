class CreatePersonalInfos < ActiveRecord::Migration[5.0]
  def change
    create_table :personal_infos do |t|
      t.float :height
      t.float :weight
      t.references :person, foreign_key: true

      t.timestamps
    end
  end
end
